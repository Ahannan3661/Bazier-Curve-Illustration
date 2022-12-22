import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class BazierCurve extends JFrame implements ActionListener
{
	private static int width = 800;
	private static int height = 600;
	private ArrayList<Point2D> points = new ArrayList<>();
	private static final int steps = 10000;
	private static final double stepInc = (1.0/(steps-1.0));
	
	public BazierCurve() 
	{
        super("Bazier Curve");
        getContentPane().setBackground(Color.WHITE);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent e) 
            { 
             points.add(new Point(e.getX(),e.getY()));
             repaint();
            } 
           }); 
    }
 
    void draw(Graphics g) 
    {
    	Graphics2D g2d = (Graphics2D) g;
    	for(int i=0 ; i<points.size() ; i++)
    	{
    		g2d.fillOval((int)points.get(i).getX(),(int)points.get(i).getY(),3,3);
    	}
        if(points.size() == 2)
        {
        	Point2D p0 = points.get(0);
        	Point2D p1 = points.get(1);
        	double u = 0;
        	for(int i=0 ; i<steps ; i++)
        	{
        		double x = ((1-u)*p0.getX())+(u*p1.getX());
        		double y = ((1-u)*p0.getY())+(u*p1.getY());
        		g2d.fillOval((int)(x),(int)(y),3,3);
        		u += stepInc;
        	}
        }
        else if(points.size() == 3)
        {
        	Point2D p0 = points.get(0);
        	Point2D p1 = points.get(1);
        	Point2D p2 = points.get(2);
        	double u = 0;
        	for(int i=0 ; i<steps ; i++)
        	{
        		double x = Math.pow((1-u),2)*p0.getX() + 2*(1-u)*u*p1.getX() + Math.pow(u,2)*p2.getX();
        		double y = Math.pow((1-u),2)*p0.getY() + 2*(1-u)*u*p1.getY() + Math.pow(u,2)*p2.getY();
        		g2d.fillOval((int)(x),(int)(y),3,3);
        		u += stepInc;
        	}
        	p0 = points.get(1);
        	p1 = points.get(2);
        	u = 0;
        	for(int i=0 ; i<steps ; i++)
        	{
        		double x = ((1-u)*p0.getX())+(u*p1.getX());
        		double y = ((1-u)*p0.getY())+(u*p1.getY());
        		g2d.fillOval((int)(x),(int)(y),3,3);
        		u += stepInc;
        	}
        }
        else if(points.size() == 4)
        {
        	Point2D p0 = points.get(0);
        	Point2D p1 = points.get(1);
        	Point2D p2 = points.get(2);
        	Point2D p3 = points.get(3);
        	double u = 0;
        	for(int i=0 ; i<steps ; i++)
        	{
        		double x = Math.pow((1-u),3)*p0.getX() + 3*Math.pow((1-u),2)*u*p1.getX() + 3*(1-u)*Math.pow(u,2)*p2.getX() + Math.pow(u,3)*p3.getX();
        		double y = Math.pow((1-u),3)*p0.getY() + 3*Math.pow((1-u),2)*u*p1.getY() + 3*(1-u)*Math.pow(u,2)*p2.getY() + Math.pow(u,3)*p3.getY();
        		g2d.fillOval((int)(x),(int)(y),3,3);
        		u += stepInc;	
        	}
        	p0 = points.get(2);
        	p1 = points.get(3);
        	u = 0;
        	for(int i=0 ; i<steps ; i++)
        	{
        		double x = ((1-u)*p0.getX())+(u*p1.getX());
        		double y = ((1-u)*p0.getY())+(u*p1.getY());
        		g2d.fillOval((int)(x),(int)(y),3,3);
        		u += stepInc;
        	}
        }
        else if(points.size() == 5)
        {
        	Point2D p0 = points.get(0);
        	Point2D p1 = points.get(1);
        	Point2D p2 = points.get(2);
        	Point2D p3 = points.get(3);
        	Point2D p4 = points.get(4);
        	double u = 0;
        	for(int i=0 ; i<steps ; i++)
        	{
        		double x = Math.pow((1-u),4)*p0.getX() + 4*Math.pow((1-u),3)*u*p1.getX() + 6*Math.pow((1-u),2)*Math.pow(u,2)*p2.getX() + 4*(1-u)*Math.pow(u,3)*p3.getX() + Math.pow(u,4)*p4.getX();
        		double y = Math.pow((1-u),4)*p0.getY() + 4*Math.pow((1-u),3)*u*p1.getY() + 6*Math.pow((1-u),2)*Math.pow(u,2)*p2.getY() + 4*(1-u)*Math.pow(u,3)*p3.getY() + Math.pow(u,4)*p4.getY();
        		g2d.fillOval((int)(x),(int)(y),3,3);
        		u += stepInc;	
        	}
        	p0 = points.get(3);
        	p1 = points.get(4);
        	u = 0;
        	for(int i=0 ; i<steps ; i++)
        	{
        		double x = ((1-u)*p0.getX())+(u*p1.getX());
        		double y = ((1-u)*p0.getY())+(u*p1.getY());
        		g2d.fillOval((int)(x),(int)(y),3,3);
        		u += stepInc;
        	}
        }
    }
    
    public void paint(Graphics g) 
    {
        draw(g);
    }
 
    public static void main(String[] args) throws Exception 
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() 
            {
            	new BazierCurve().setVisible(true);
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		repaint();
	}

}

