

public class Robot implements Runnable{
    private String name;
    private boolean running;
    Exploration explore;

    public Robot(String name)
    {
        this.name=name;
        this.running = true;
    }


    @Override
    public void run() {
        while (running) {
            //pick a new cell to explore
            //System.out.println(explore.getMap().getMatrix().length);
            for(int row=0;row<explore.getMap().getMatrix().length;row++)
            {
                for(int col=0; col<explore.getMap().getMatrix()[row].length;col++)
                {
                    if(!explore.getMap().getMatrix()[row][col].isVisited()) {

                        explore.getMap().visit(row, col, this);
                    }
                }
            }
            running = false;
            //make the robot sleep for some time
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public String getName() {
        return name;
    }

    public Exploration getExplore() {
        return explore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }


    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                '}';
    }
}
