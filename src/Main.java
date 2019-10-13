import java.util.Scanner;

class Light
{
    public enum State
    {
        RED,
        YELLOW,
        GREEN,
        YELLOW_BLINK
    };

    public Light()
    {
        this.currentState = State.YELLOW_BLINK;
    }

    private State currentState;


    public void setState(State s)
    {
        this.currentState = s;
    }

    public void printState(State s)
    {
        switch (s)
        {
            case RED:
                System.out.println("Красный");
                break;
            case GREEN:
                System.out.println("Зеленый");
                break;
            case YELLOW:
                System.out.println("Желтый");
                break;
            case YELLOW_BLINK:
                System.out.println("Желтый мигающий");
                break;
            default:
                break;
        }
    }

    public void changeStateYButton(State s)
    {
        if (s == State.RED)
        {
            setState(State.YELLOW);
        }
        else if (s == State.YELLOW)
        {
            setState(State.GREEN);
        }
        else if (s == State.GREEN)
        {
            setState(State.YELLOW);
        }
    }

    public void changeStateBButton(State s)
    {
        if (s == State.RED)
        {
            setState(State.YELLOW);
        }
        else if (s == State.YELLOW)
        {
            setState(State.RED);
        }
        else if (s == State.GREEN)
        {
            setState(State.YELLOW);
        }
    }

    public void changeStateWorkButton(State s)
    {
        if (s == State.YELLOW_BLINK)
        {
            setState(State.YELLOW);
        }
        else
        {
            setState(State.YELLOW_BLINK);
        }
    }

    void run()
    {
        Scanner s = new Scanner(System.in);
        while (true)
        {
            String command = s.next();

            if (command.compareTo("Y") == 0)
            {
                changeStateYButton(currentState);
            }
            else if (command.compareTo("B") == 0)
            {
                changeStateBButton(currentState);
            }
            else if (command.compareTo("Work") == 0)
            {
                changeStateWorkButton(currentState);
            }
            else
            {
                System.out.println("Wrong command");
                return;
            }

            printState(currentState);
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Light l = new Light();

        l.run();
    }
}