import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.KeyStroke;

public class Main {
    public static ArrayList<Node> nodeList = new ArrayList<Node>();
    public static Translation worldSpaceToScreenSpace;
    public static Panel p;
    public static Mouse mouseListener = new Mouse();
    public static void main(String args[]) {
        createScreens();
        
        for(int i = 0; i < 2; i++) {
            nodeList.add(new Node());
            
        }
        nodeList.get(0).setPoint(new Point2D.Double(1, 1));
        nodeList.get(0).setGate(new Or());
        nodeList.get(1).setPoint(new Point2D.Double(2, 2));
        nodeList.get(1).setGate(new Switch());
        // nodeList.get(1).setPoint(new Point2D.Double(5, 7));
        // nodeList.get(1).setGate(new Or());
        // nodeList.get(2).setPoint(new Point2D.Double(-4, -4));
        // nodeList.get(2).setGate(new And());

        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            tick();
        }
    }

    static void tick() {
        for (Node workingNode : nodeList) {
            workingNode.evaluateGate(); 
        }
        for (Node workingNode : nodeList) {
            workingNode.nextOuputToCurrentOutput(); 
        }
        for (Node workingNode : nodeList) {
               
            for (Node workedNode1 : workingNode.connectionsInput1) {
                workingNode.recieveinput1(false);
                if (workedNode1.getOutput() == true) {
                    workingNode.recieveinput1(true);
                    break;
                }
            }
            for (Node workedNode2 : workingNode.connectionsInput2) {
                workingNode.recieveinput2(false);
                if (workedNode2.getOutput() == true) {
                    workingNode.recieveinput2(true);
                    break;
                }
            }
        }
    }

    static void createScreens() {
        Screen sc = new Screen();
        p = new Panel();
        p.addMouseListener(mouseListener);
        p.addMouseMotionListener(mouseListener);
        p.addMouseWheelListener(mouseListener);
        sc.add(p);
        setNumPad();
        sc.setVisible(true);
        worldSpaceToScreenSpace = new Translation(10, 10, p.getWidth(), p.getHeight());
    }

    static void setNumPad() {
        And.action and = new And.action();
        Nand.action nand = new Nand.action();
        Nor.action nor = new Nor.action();
        Or.action or = new Or.action();
        Xor.action xor = new Xor.action();
        Xnor.action xnor = new Xnor.action();
        Not.action not = new Not.action();
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0), "AND");
        p.getActionMap().put("AND", and);
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0), "NAND");
        p.getActionMap().put("NAND", nand);
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0), "NOR");
        p.getActionMap().put("NOR", nor);
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0), "OR");
        p.getActionMap().put("OR", or);
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0), "XOR");
        p.getActionMap().put("XOR", xor);
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0), "XNOR");
        p.getActionMap().put("XNOR", xnor);
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0), "NOT");
        p.getActionMap().put("NOT", not);
    }
    

}
