package com.JFaceDetection;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class JFaceDetection {
   
	public static void main(String args[]) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.out.println("Done");
		
		String imgFile = "images/bacche.jpg";
		Mat src = Imgcodecs.imread(imgFile);
		
		String file = "xml/lbpcascade_frontalface.xml";
		CascadeClassifier cc = new CascadeClassifier(file);
		
		MatOfRect faceDetect = new MatOfRect();
		cc.detectMultiScale(src, faceDetect);
		System.out.println(String.format("Detected Faces: %d", faceDetect.toArray().length));
		
		for(Rect rect : faceDetect.toArray()) {
			Imgproc.rectangle(src, new Point(rect.x , rect.y) , new Point(rect.x + rect.width , 
					rect.y + rect.height), new Scalar(0,0,255), 3);
		}
		
		Imgcodecs.imwrite("images/bacche_out.jpg" , src);
		System.out.println("Image detection finished !!");
	}
}
