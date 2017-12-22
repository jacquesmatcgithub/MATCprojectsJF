package java112.project3;

/**
 *  This is a JavaBean to demonstrate using beans with JSP.
 *
 *@author    eknapp
 */
public class BeanOne {

    private String data;
    private String description;
    private String pictureName;

    /**
     * Returns the value of pictureName.
     * @return String The name of the picture.
     */
    public String getPictureName() {
        return pictureName;
    }


    /**
     * Sets the value of pictureName.
     * @param pictureName The value to assign pictureName.
     */
    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }


    /**
     *  Constructor for the BeanOne object
     */
    public BeanOne() {
        data = "default value";
        description = "default value";
        pictureName = "default value";
    }

    /**
     *  Gets the Data attribute of the BeanOne object
     *
     *@return    The Data value
     */
    public String getData() {
        return data;
    }

    /**
     *  Sets the Data attribute of the BeanOne object
     *
     *@param  data  The new Data value
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Returns the value of description.
     * @return String A string containing the description.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the value of description.
     * @param description The value to assign description.
     */
    public void setDescription(String description) {
        this.description = description;
    }


}
