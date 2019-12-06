package UserInterface;

import DatabaseConnection.CriminalDB;
import DatabaseConnection.OffenseTypeDB;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.DMatch;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.FeatureDetector;
import org.opencv.features2d.KeyPoint;
import org.opencv.highgui.Highgui;

public class SearchOriginalPhoto extends javax.swing.JFrame {

    static String manipulated_image_path = "";
    static String original_image_path = "D:\\Assignments\\Final Project\\MugshotIdentificationSystem\\Criminal Original Photos\\";
    static Map<Integer, Double> percentages = new HashMap();
    public static int highestPercentageID = 0;

    public SearchOriginalPhoto() {
        initComponents();
        lb_heading_matching.setText(null);
        lb_percentage.setText(null);
        loadOffenseTypes();
        setLocationRelativeTo(null);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    private void loadOffenseTypes() {
        Vector v = new OffenseTypeDB().getAllOffenseTypes();
        combo_crime_type.setModel(new DefaultComboBoxModel(v));
    }

    //Reading image to the Mat 
    private Mat readImage(String imagePath) {
        //Mat--->n-dimensional level array class
        //imread()--->Loads an image from a file
        //imagePath-->Name of file to be loaded
        //Highgui.CV_LOAD_IMAGE_COLOR-->this parametr spcifies the color type of a loaded image.
        //CV_LOAD_IMAGE_COLOR-->convert image to the color one
        Mat imageMat = Highgui.imread(imagePath, Highgui.CV_LOAD_IMAGE_COLOR);
        return imageMat;
    }

    //detect keypoints of the image
    private MatOfKeyPoint detectKeyPoint(Mat matImage) {
        MatOfKeyPoint imageKeyPoints = new MatOfKeyPoint();
        //create()-->Creates a feature detector by its name
        FeatureDetector featureDetector = FeatureDetector.create(FeatureDetector.SIFT);
        //FeatureDetector::detect---->Detects keypoints in an image
        //matImage-->Image    imageKeyPoints-->The detected keypoints
        featureDetector.detect(matImage, imageKeyPoints);
        return imageKeyPoints;
    }

    //compute descriptors
    private MatOfKeyPoint computeDescriptors(Mat matImage, MatOfKeyPoint imageKeyPoints) {
        MatOfKeyPoint imageDescriptors = new MatOfKeyPoint();
        //create()-->Creates a descriptor extractor by name
        DescriptorExtractor descriptorExtractor = DescriptorExtractor.create(DescriptorExtractor.SIFT);
       //DescriptorExtractor::compute--->Computes the descriptors for a set of keypoints detected in an image
        //matImage-->Image      imageKeyPoints--->Input collection of keypoints   imageDescriptors--->Computed descriptors   
        descriptorExtractor.compute(matImage, imageKeyPoints, imageDescriptors);
        return imageDescriptors;
    }

    //compare descriptors of two images
    private LinkedList<DMatch> compareTwoImages(MatOfKeyPoint imageDescriptor1, MatOfKeyPoint imageDescriptor2) {
        List matches = new LinkedList();
        DescriptorMatcher descriptorMatcher = DescriptorMatcher.create(DescriptorMatcher.FLANNBASED);
        //knnMatch()--->Finds the k best matches for each descriptor from a query set
        //In here k=2
        //imageDescriptor1--->Query set of descriptors
        //imageDescriptor2--->Train set of descriptors
        //matches--->Matches. Each matches[i] is k or less matches for the same query descriptor
        //Count of best matches found per each query descriptor or less if a query descriptor has less than k possible matches in total
        //Note: Nearest Neighbor matching is used in here
        descriptorMatcher.knnMatch(imageDescriptor1, imageDescriptor2, matches, 2);

        //calculate good match list
        /*After matching,invalid results should be discarded, 
         basically good matches should be filtered out. 
         To do that Nearest Neighbor Distance Ratio is used.
         */
        //Class DMatch-->Structure for matching:query descriptor index, train descriptor index,
        //train image index and distance between descriptors
        LinkedList<DMatch> goodMatchesList = new LinkedList<>();

        float nndrRatio = 0.7f;

        for (int i = 0; i < matches.size(); i++) {
            //Class MatOfDMatch-->A matrix whose element is cv::DMatch 
            MatOfDMatch matofDMatch = (MatOfDMatch) matches.get(i);
            DMatch[] dmatcharray = matofDMatch.toArray();
            DMatch m1 = dmatcharray[0];
            DMatch m2 = dmatcharray[1];

            if (m1.distance <= m2.distance * nndrRatio) {
                goodMatchesList.addLast(m1);
            }
        }
        return goodMatchesList;
    }

    //this method is for retrieving the matching percentage between manipulated and original image
    private double getPercentage(MatOfKeyPoint originalImageMatOfKeyPoint, LinkedList<DMatch> goodMatchList) {
        double percentage;
        List<KeyPoint> imageKeyPoints = originalImageMatOfKeyPoint.toList();
        percentage = ((double) goodMatchList.size() / (double) imageKeyPoints.size()) * 100;
        DecimalFormat format = new DecimalFormat("#.00");
        double new_percentage = Double.parseDouble(format.format(percentage));
        return new_percentage;
    }

    //this method is for get the highest percentage
    private double getHighestPercentage(Map<Integer, Double> percentages) {
        double highestPercentage = 0.00;
        Map<Integer, Double> map = sortByValues((HashMap) percentages);
        int count = 0;//this variable is for counting the key-value pair
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator2.next();
            count++;
            if (count == map.size()) {
                highestPercentage = (double) me2.getValue();
                highestPercentageID = (int) me2.getKey();
            }
        }
        return highestPercentage;
    }

    //this method is for sorting the HashMap
    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

       // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    //this method is for setting the original image which has the highest percentage in the label
    private void setHighestPercentageImage() {
        String path = "D:\\Assignments\\Final Project\\MugshotIdentificationSystem\\Criminal Original Photos\\" + "img+" + highestPercentageID + ".jpg";
        lb_matching_photo.setIcon(new ImageIcon(path));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lb_matching_photo = new javax.swing.JLabel();
        lb_manipulated_photo = new javax.swing.JLabel();
        lb_heading_matching = new javax.swing.JLabel();
        lb_percentage = new javax.swing.JLabel();
        btn_upload = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combo_crime_type = new javax.swing.JComboBox();
        btn_check = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_viewDetails = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_matching_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        jPanel2.add(lb_matching_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 300, 440));

        lb_manipulated_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        jPanel2.add(lb_manipulated_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 300, 440));

        lb_heading_matching.setFont(new java.awt.Font("Cambria", 1, 22)); // NOI18N
        lb_heading_matching.setText("MATCHING");
        jPanel2.add(lb_heading_matching, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 120, 30));

        lb_percentage.setFont(new java.awt.Font("Cambria", 1, 22)); // NOI18N
        lb_percentage.setText("92%");
        jPanel2.add(lb_percentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        btn_upload.setText("Upload");
        btn_upload.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uploadActionPerformed(evt);
            }
        });
        jPanel2.add(btn_upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 60, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Select the crime type:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        jPanel2.add(combo_crime_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 170, -1));

        btn_check.setText("Check");
        btn_check.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkActionPerformed(evt);
            }
        });
        jPanel2.add(btn_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, 80, 30));

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/close.gif"))); // NOI18N
        btn_exit.setText("Exit");
        btn_exit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        jPanel2.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 70, 30));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/clear.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel2.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, 70, 30));

        btn_viewDetails.setText("View Details");
        btn_viewDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_viewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewDetailsActionPerformed(evt);
            }
        });
        jPanel2.add(btn_viewDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, 80, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 860, 640));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SEARCHING ORIGINAL PHOTO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        lb_manipulated_photo.setIcon(null);
        lb_matching_photo.setIcon(null);
        lb_heading_matching.setText(null);
        lb_percentage.setText(null);
        combo_crime_type.setSelectedIndex(0);
        lb_heading_matching.setText("");
        lb_percentage.setText("");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uploadActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        File f = fc.getSelectedFile();
        if (f != null) {
            manipulated_image_path = f.getAbsolutePath();
            lb_manipulated_photo.setIcon(new ImageIcon(manipulated_image_path));
        }
    }//GEN-LAST:event_btn_uploadActionPerformed

    private void btn_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkActionPerformed
        if (!manipulated_image_path.equals("")) {
            //loading manipulated image to the Mat
            Mat matManipulatedImage = readImage(manipulated_image_path);

            //detecting keypoints of the manipulated image
            MatOfKeyPoint matOfKeyPointManipulatedImage = detectKeyPoint(matManipulatedImage);

            //computing descriptors of the manipulated image
            MatOfKeyPoint manipulatedImageDescriptors = computeDescriptors(matManipulatedImage, matOfKeyPointManipulatedImage);

            //Get all the criminals' id in the database
            String type = String.valueOf(combo_crime_type.getSelectedItem());
            ArrayList<Integer> criminalsID = new CriminalDB().getAllCriminalIds(type);
            if (criminalsID.size() != 0) {
                for (Integer id : criminalsID) {
                    String imagePath = original_image_path + "img+" + id + ".jpg";
                    Mat matOriginalImage = readImage(imagePath);
                    MatOfKeyPoint matOfKeyPointOriginalImage = detectKeyPoint(matOriginalImage);
                    MatOfKeyPoint originalImageDescriptors = computeDescriptors(matOriginalImage, matOfKeyPointOriginalImage);

                    //comparing original image and the manipulated image
                    LinkedList<DMatch> goodMatchesList = compareTwoImages(manipulatedImageDescriptors, originalImageDescriptors);

                    //get the matching percentage
                    double percentage = getPercentage(matOfKeyPointOriginalImage, goodMatchesList);
                    //System.out.println(percentage);
                    percentages.put(id, percentage);
                }
                //System.out.println(percentages);
                double highestPercentage = getHighestPercentage(percentages);
                lb_percentage.setText(highestPercentage + "%");
                lb_heading_matching.setText("MATCHING");
                setHighestPercentageImage();
            } else {
                JOptionPane.showMessageDialog(this, "No Offense Records Found for Selected Offense Type!");
            }
        }
    }//GEN-LAST:event_btn_checkActionPerformed

    private void btn_viewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewDetailsActionPerformed
        new CriminalDetails().setVisible(true);
    }//GEN-LAST:event_btn_viewDetailsActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_btn_exitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchOriginalPhoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SearchOriginalPhoto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_check;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_upload;
    private javax.swing.JButton btn_viewDetails;
    private javax.swing.JComboBox combo_crime_type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_heading_matching;
    private javax.swing.JLabel lb_manipulated_photo;
    private javax.swing.JLabel lb_matching_photo;
    private javax.swing.JLabel lb_percentage;
    // End of variables declaration//GEN-END:variables
}
