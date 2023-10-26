package src.main.seminar_5.model;

public class Fork {

    private static int forkCounter = 1;
    
    private boolean avaliable;
    private int forkNo;

    {
        forkNo = forkCounter++;
    }

    public getForkNo(){
        return forkNo;
    }

    public boolean getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }
}