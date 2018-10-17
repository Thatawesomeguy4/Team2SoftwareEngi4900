
package userDataInteraction;

/**
 * @author Derek Pendleton
 * @version 10-15-18
 * 
 * 	This is the superclass of all windows.
 *
 */
public class WindowTemplate 
{
	
	private double windowHeight;
	private double windowWidth;
	
	public void setHeight(double height)
	{
		this.windowHeight = height;
	}
	
	public void setWidth(double width)
	{
		this.windowWidth = width;
	}
	
	public double getHeight()
	{
		return this.windowHeight;
	}
	
	public double getWidth()
	{
		return this.windowWidth;
	}
	
	//override in subclass
	public int buildWindow()
	{
		return 0;
	}
	
	//might remove, just here for testing
	public void refresh()
	{
		this.buildWindow();
	}
}
