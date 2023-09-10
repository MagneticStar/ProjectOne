import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class Main {
    public static ArrayList<Node> nodeList = new ArrayList<Node>();
    public static ArrayList<Node> deletedNodeList = new ArrayList<Node>();
    public static Translation worldSpaceToScreenSpace;
    public static Panel p;
    public static Mouse mouseListener = new Mouse();
    public static Gate nextGatePlacement;
    public static Node lastNodeClicked = null;
    public static int nextInputChoice = 1;
    private static boolean ticks = false;
    public static void main(String args[]) {
        createScreens();
        while (ticks) {
            tick();
        }
    }
    //evaluates the inputs and outputs of each gate each tick and sets the inputs of the next gate to evaluate the following tick
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
        Main.p.repaint();
    }

    static void createScreens() {
        Screen sc = new Screen();
        p = new Panel();
        p.addMouseListener(mouseListener);
        p.addMouseMotionListener(mouseListener);
        p.addMouseWheelListener(mouseListener);
        sc.add(p);
        setUpKey();
        sc.setVisible(true);
        worldSpaceToScreenSpace = new Translation(10, 10, p.getWidth(), p.getHeight());
    }
    static class CtrlZ extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            if (nodeList.size() > 1) {
                deletedNodeList.add(nodeList.remove(nodeList.size()-1));
            p.repaint();
            }
        }
    }
    static class CtrlY extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            if (deletedNodeList.size() > 1) {
            nodeList.add(deletedNodeList.remove(deletedNodeList.size()-1));
            p.repaint();
            }
        }
    }
    static class tickbutton extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            tick();
            ticks = true;
        }
    }
    //implements keyboard input for each gate type and panning
    static void setUpKey() {
        And.action and = new And.action();
        Nand.action nand = new Nand.action();
        Nor.action nor = new Nor.action();
        Or.action or = new Or.action();
        Xor.action xor = new Xor.action();
        Xnor.action xnor = new Xnor.action();
        Not.action not = new Not.action();
        Switch.action swith = new Switch.action();
        Light.action light = new Light.action();

        Arrow.Up up = new Arrow.Up();
        Arrow.Down down = new Arrow.Down();
        Arrow.Left left = new Arrow.Left();
        Arrow.Right right = new Arrow.Right();
        Node.setNextInput1 set1 = new Node.setNextInput1();
        Node.setNextInput2 set2 = new Node.setNextInput2();


        CtrlZ ctrlZ = new CtrlZ();
        CtrlY ctrlY = new CtrlY();

        tickbutton tickb = new tickbutton();
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "tick");
        p.getActionMap().put("tick", tickb);


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
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0), "SWITCH");
        p.getActionMap().put("SWITCH", swith);
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0), "LIGHT");
        p.getActionMap().put("LIGHT", light);

        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UP");
        p.getActionMap().put("UP", up);
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DOWN");
        p.getActionMap().put("DOWN", down);
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "LEFT");
        p.getActionMap().put("LEFT", left);
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RIGHT");
        p.getActionMap().put("RIGHT", right);

        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0), "CTRLZ");
        p.getActionMap().put("CTRLZ", ctrlZ);
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, 0), "CTRLY");
        p.getActionMap().put("CTRLY", ctrlY);
    

        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0), "IN1");
        p.getActionMap().put("IN1", set1);
        p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL, 0), "IN2");
        p.getActionMap().put("IN2", set2);
    }
}
