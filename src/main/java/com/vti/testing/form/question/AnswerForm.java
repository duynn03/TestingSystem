//
package com.vti.testing.form.question;

/**
 * This class is answer form.
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 25, 2020
 */
public class AnswerForm {

	private String key;
	private boolean isCorrect;
	private ImageForm image;

	
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the isCorrect
	 */
	public boolean isCorrect() {
		return isCorrect;
	}
	/**
	 * @param isCorrect the isCorrect to set
	 */
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	/**
	 * @return the image
	 */
	public ImageForm getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(ImageForm image) {
		this.image = image;
	}

	
}
