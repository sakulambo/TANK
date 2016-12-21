/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tank;


import java.awt.*;

public class Explote extends ImageObj{
    // Image of animation.
    private Image animImage;

    // Width of one frame in animated image.
    private int frameWidth;

    // Height of the frame(image).
    private int frameHeight;

    // Number of frames in the animation image.
    private int numberOfFrames;

    // Amount of time between frames in milliseconds. (How many time in milliseconds will be one frame shown before showing next frame?)
    private long frameTime;

    // Time when the frame started showing. (We use this to calculate the time for the next frame.)
    private long startingFrameTime;

    // Time when we show next frame. (When current time is equal or greater then time in "timeForNextFrame", it's time to move to the next frame of the animation.)
    private long timeForNextFrame;

    // Current frame number.
    private int currentFrameNumber;

    // Should animation repeat in loop?
    private boolean loop;

    /** x and y coordinates. Where to draw the animation on the screen? */
    public int x;
    public int y;

    // Starting x coordinate of the current frame in the animation image.
    private int startingXOfFrameInImage;

    // Ending x coordinate of the current frame in the animation image.
    private int endingXOfFrameInImage;

    /** State of animation. Is it still active or is it finished? We need this so that we can check and delete animation when is it finished. */
    public boolean active;
    
    // In milliseconds. How long to wait before starting the animation and displaying it?
    private long showDelay;
    
    // At what time was animation created.
    private long timeOfAnimationCration;

    /**
     * Creates animation.
     * 
     * @param animImage Image of animation.
     * @param frameWidth Width of the frame in animation image "animImage".
     * @param frameHeight Height of the frame in animation image "animImage" - height of the animation image "animImage".
     * @param numberOfFrames Number of frames in the animation image.
     * @param frameTime Amount of time that each frame will be shown before moving to the next one in milliseconds.
     * @param loop Should animation repeat in loop?
     * @param x x coordinate. Where to draw the animation on the screen?
     * @param y y coordinate. Where to draw the animation on the screen?
     * @param showDelay In milliseconds. How long to wait before starting the animation and displaying it?
     */
 
    
     public Explote(String animImage, int frameWidth, int frameHeight, int numberOfFrames, long frameTime, boolean loop, int x, int y, long showDelay){ 
        super(animImage,x,y,0,0,0,true);
        
        this.animImage = super.getImage();
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.numberOfFrames = numberOfFrames;
        this.frameTime = frameTime;
        this.loop = loop;

        super.x = x- this.frameWidth/2;
        super.y = y-this.frameHeight/2;
        
        this.showDelay = showDelay;
        
        timeOfAnimationCration = System.currentTimeMillis();

        startingXOfFrameInImage = 0;
        endingXOfFrameInImage = frameWidth;

        startingFrameTime = System.currentTimeMillis() + showDelay;
        timeForNextFrame = startingFrameTime + this.frameTime;
        currentFrameNumber = 0;
        active = true;
     }

 

    public Image getAnimImage() {
        return animImage;
    }

    public void setAnimImage(Image animImage) {
        this.animImage = animImage;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }

    public int getNumberOfFrames() {
        return numberOfFrames;
    }

    public void setNumberOfFrames(int numberOfFrames) {
        this.numberOfFrames = numberOfFrames;
    }

    public long getFrameTime() {
        return frameTime;
    }

    public void setFrameTime(long frameTime) {
        this.frameTime = frameTime;
    }

    public long getStartingFrameTime() {
        return startingFrameTime;
    }

    public void setStartingFrameTime(long startingFrameTime) {
        this.startingFrameTime = startingFrameTime;
    }

    public long getTimeForNextFrame() {
        return timeForNextFrame;
    }

    public void setTimeForNextFrame(long timeForNextFrame) {
        this.timeForNextFrame = timeForNextFrame;
    }

    public int getCurrentFrameNumber() {
        return currentFrameNumber;
    }

    public void setCurrentFrameNumber(int currentFrameNumber) {
        this.currentFrameNumber = currentFrameNumber;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
        
    }
    
    public int getStartingXOfFrameInImage() {
        return startingXOfFrameInImage;
    }

    public void setStartingXOfFrameInImage(int startingXOfFrameInImage) {
        this.startingXOfFrameInImage = startingXOfFrameInImage;
    }

    public int getEndingXOfFrameInImage() {
        return endingXOfFrameInImage;
    }

    public void setEndingXOfFrameInImage(int endingXOfFrameInImage) {
        this.endingXOfFrameInImage = endingXOfFrameInImage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getShowDelay() {
        return showDelay;
    }

    public void setShowDelay(long showDelay) {
        this.showDelay = showDelay;
    }

    public long getTimeOfAnimationCration() {
        return timeOfAnimationCration;
    }

    public void setTimeOfAnimationCration(long timeOfAnimationCration) {
        this.timeOfAnimationCration = timeOfAnimationCration;
    }
     
     


    /**
     * Changes the coordinates of the animation.
     * 
     * @param x x coordinate. Where to draw the animation on the screen?
     * @param y y coordinate. Where to draw the animation on the screen?
     */
    public void changeCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }


    /**
     * It checks if it's time to show next frame of the animation.
     * It also checks if the animation is finished.
     */
    private void Update(){
        if(timeForNextFrame <= System.currentTimeMillis())
        {    

            // Next frame.
            currentFrameNumber++;           

            // If the animation is reached the end, we restart it by seting current frame to zero. If the animation isn't loop then we set that animation isn't active.
            if(currentFrameNumber >= numberOfFrames)
            {
                currentFrameNumber = 0;      

                // If the animation isn't loop then we set that animation isn't active.
                if(!loop)
                    active = false;
            }
            // Starting and ending coordinates for cuting the current frame image out of the animation image.
            startingXOfFrameInImage = currentFrameNumber * frameWidth;
            endingXOfFrameInImage = startingXOfFrameInImage + frameWidth;
            // Set time for the next frame.
            startingFrameTime = System.currentTimeMillis();
            timeForNextFrame = startingFrameTime + frameTime;
        }
    }

    /**
     * Draws current frame of the animation.
     * 
     * @param g2d Graphics2D
     */
    @Override
    public void paint(Graphics g){
        this.Update();
        
        Graphics2D g2d = (Graphics2D) g;
        if(this.active && this.timeOfAnimationCration + this.showDelay <= System.currentTimeMillis())
            g2d.drawImage(animImage, x, y, x + frameWidth, y + frameHeight, startingXOfFrameInImage, 0, endingXOfFrameInImage, frameHeight, null);       
                    
            
    }
}
