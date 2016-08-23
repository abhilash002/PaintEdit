package Paint5;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

public class Painting {
	
	private JFrame frame;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu fileMenu , homeMenu, viewMenu;
	private JMenuItem menuItem;
	private ImageIcon Icon ;
	private Image image;
	private JPanel toolPanel; 
	private JToolBar tool,panelt,panelt1;
	final private Color white ,blue ;
	private JButton button;
	private JTextArea shapes;
	private JScrollPane scroll;
	private JColorChooser colorSel;
	private JComponent draw;
	public JTextComponent pad;
	public Dimension sep;
	
	public Painting(){
		
	sep = new Dimension(1, 70)	;
	white = new Color(255, 255, 255);
	blue = new Color(0,100,255);
	frame = new JFrame("Paint 5");
	frame.getContentPane().setLayout(new BorderLayout());
	panel = new JPanel();
	menuBar = new JMenuBar();
	frame.setJMenuBar(menuBar);
	fileMenu = new JMenu("    File    ");
	fileMenu.setBackground(blue);
	menuBar.add(fileMenu);
		
	homeMenu = new JMenu("    Home    ");
	menuBar.add(homeMenu);
	//frame.add(panel);
	drawPad pad = new drawPad();
	
	frame.add(pad,BorderLayout.CENTER);
	
	toolPanel = new JPanel();
	frame.add(toolPanel,BorderLayout.NORTH);
	toolPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	toolPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	tool   = new JToolBar("ClipBoard");
	toolPanel.add(tool);
	
	Icon   = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Paste.png");
	button = new JButton("Paste",Icon);
	button.setVerticalTextPosition(SwingConstants.BOTTOM);
	button.setHorizontalTextPosition(SwingConstants.CENTER);
	tool.add(button);
	tool.setFloatable(false);
	
	panelt = new JToolBar();
	panelt.setOrientation(JToolBar.VERTICAL);
	Icon   = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Cut.png");
	image  = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon   = new ImageIcon(image);
	button = new JButton("Cut",Icon);
	panelt.add(button);
	
	Icon   = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Copy.png");
	image  = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon   = new ImageIcon(image);
	button = new JButton("Copy",Icon);
	panelt.add(button);
	panelt.setFloatable(false);
	tool.add(panelt);
	tool.addSeparator(sep);

	tool   = new JToolBar();
	toolPanel.add(tool);
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Selection.png");
	button = new JButton("Select",Icon);
	button.setVerticalTextPosition(SwingConstants.BOTTOM);
	button.setHorizontalTextPosition(SwingConstants.CENTER);
	tool.add(button);
	tool.setFloatable(false);

	panelt = new JToolBar();
	panelt.setOrientation(JToolBar.VERTICAL);
	
	Icon   = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Crop.png");
	image  = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon   = new ImageIcon(image);
	button = new JButton("Crop",Icon);
	panelt.add(button);
	
	Icon   = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Resize image.png");
	image  = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon   = new ImageIcon(image);
	button = new JButton("Resize",Icon);
	panelt.add(button);
	
	Icon   = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Rotation.png");
	image  = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon   = new ImageIcon(image);
	button = new JButton("Rotate",Icon);
	panelt.add(button);
	panelt.setFloatable(false);
	tool.add(panelt);
	tool.addSeparator(sep);

	
	tool   = new JToolBar();
	tool.setOrientation(JToolBar.VERTICAL);
	toolPanel.add(tool);
	
	panelt = new JToolBar();
	Icon   = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Pencil.png");
	image  = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	button = new JButton(Icon);
	panelt.add(button);
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Fill.png");
	image = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	button = new JButton(Icon);
	panelt.add(button);
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Text tool.png");
	image = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	button = new JButton(Icon);
	panelt.add(button);
	panelt.setFloatable(false);
	
	panelt1 = new JToolBar();
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Eraser.png");
	image = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	button = new JButton(Icon);
	panelt1.add(button);
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Dropper.png");
	image = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	button = new JButton(Icon);
	panelt1.add(button);
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Zoom.png");
	image = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	button = new JButton(Icon);
	panelt1.add(button);
	panelt1.setFloatable(false);
	tool.add(panelt);
	tool.setFloatable(false);
	tool.add(panelt1);
	tool.setFloatable(false);
	
	tool = new JToolBar();
	toolPanel.add(tool);
	tool.addSeparator(sep);
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Brush.png");
	button = new JButton("Brushes",Icon);
	button.setVerticalTextPosition(SwingConstants.BOTTOM);
	button.setHorizontalTextPosition(SwingConstants.CENTER);
	tool.add(button);
	tool.setFloatable(false);
	tool.addSeparator(sep);

	tool = new JToolBar();
	toolPanel.add(tool);
	shapes = new JTextArea("                 ");
	tool.add(shapes);
	tool.setFloatable(false);
	tool.addSeparator(sep);
	
	panelt = new JToolBar();
	panelt.setOrientation(JToolBar.VERTICAL);
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Outline.png");
	image = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	button = new JButton("Outline",Icon);
	panelt.add(button);
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Fill.png");
	image = Icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	button = new JButton("Fill",Icon);
	panelt.add(button);
	panelt.setFloatable(false);
	tool.add(panelt);
	tool.addSeparator(sep);

	shapes.setVisible(true);
	shapes.setSize(100, 50);
	shapes.setEditable(false);

	tool = new JToolBar();
	toolPanel.add(tool);

	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Brushsize.png");
	button = new JButton("Size",Icon);
	button.setVerticalTextPosition(SwingConstants.BOTTOM);
	button.setHorizontalTextPosition(SwingConstants.CENTER);
	tool.add(button);
	tool.setFloatable(false);
	tool.addSeparator(sep);

	tool = new JToolBar();
	toolPanel.add(tool);

	tool.setOrientation(JToolBar.VERTICAL);
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Brushsize.png");
	button = new JButton();
	button = new JButton("Color 1");
	button.add(getWallComponent());

	button.setVerticalTextPosition(SwingConstants.BOTTOM);
	button.setHorizontalTextPosition(SwingConstants.CENTER);
	tool.add(button);
	tool.setFloatable(false);
	
	tool = new JToolBar();
	toolPanel.add(tool);
	button = new JButton();
	button.setBackground(Color.BLACK);
	button = new JButton("Color 2");
	button.setVerticalTextPosition(SwingConstants.BOTTOM);
	button.setHorizontalTextPosition(SwingConstants.CENTER);
	tool.add(button);
	tool.setFloatable(false);
	tool.addSeparator(sep);
	//colorSel = new  JColorChooser();
	//colorSel.setPreviewPanel(new JPanel());
	//tool.add(colorSel);
	
	viewMenu = new JMenu("    View    ");
	menuBar.add(viewMenu);
	
	
	toolPanel = new JPanel();
	menuBar.setBackground(white);
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\new.png");	
	image = Icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	menuItem = new JMenuItem("New",Icon);
	fileMenu.add(menuItem);
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\open.png");	
	image = Icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	menuItem = new JMenuItem("Open",Icon);
	fileMenu.add(menuItem);
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Save.png");	
	image = Icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	menuItem = new JMenuItem("Save",Icon);
	fileMenu.add(menuItem);
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\Save As.png");	
	menuItem = new JMenuItem("Save As",Icon);
	fileMenu.add(menuItem);
	
	fileMenu.addSeparator();
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\print.png");	
	image = Icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	menuItem = new JMenuItem("Print",Icon);
	fileMenu.add(menuItem);
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\email.png");	
	image = Icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
    menuItem = new JMenuItem("Send in email",Icon);
	fileMenu.add(menuItem);
	
	fileMenu.addSeparator();
	
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\setBack.png");	
	image = Icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	menuItem = new JMenuItem("Set as desktop background",Icon);
	fileMenu.add(menuItem);
	
	fileMenu.addSeparator();
    
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\prop.png");	
	image = Icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	menuItem = new JMenuItem("Properties",Icon);
    fileMenu.add(menuItem);
    
    fileMenu.addSeparator();
	
    Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\about.png");	
	image = Icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
    menuItem = new JMenuItem("About Paint",Icon);
	fileMenu.add(menuItem);
	
	fileMenu.addSeparator();

	exitListener exitl = new exitListener();
	Icon = new ImageIcon("E:\\abhilash\\workspace\\Paint5\\bin\\Paint5\\Icons\\exit.png");	
	image = Icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	Icon = new ImageIcon(image);
	menuItem = new JMenuItem("Exit",Icon);
	menuItem.addActionListener(exitl);
	fileMenu.add(menuItem);
	
	
	homeMenuListener homem = new homeMenuListener();
	viewMenuListener viewm = new viewMenuListener();
	pasteListener pastel   = new pasteListener();
	cutListener cutl       = new cutListener();
	copyListener copyl     = new copyListener();
	selectListener selectl = new selectListener();
	cropListener cropl     = new cropListener();
	resizeListener resizel = new resizeListener();
	rotateListener rotate  = new rotateListener();
	pencilListener pencill = new pencilListener();
	fillListener filll     = new fillListener();
	textListener textl     = new textListener();
	eraserListener eraserl = new eraserListener();
	dropperListener dropperl= new dropperListener();
	zoomListener zooml     = new zoomListener();
	brushListener brushl   = new brushListener();
	outlineListener outl   = new outlineListener();
	fillshapeListener fillsl = new fillshapeListener();
	BrushsizeListener brushsl = new BrushsizeListener();
	
	homeMenu.addActionListener(homem);
	viewMenu.addActionListener(viewm);
	if(homeMenu.isSelected()){
		homeMenu.setSelected(true);
	}
	else if(viewMenu.isSelected()){
		viewMenu.setSelected(true);
	}
	
	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	frame.setPreferredSize(new Dimension(600,400));
	frame.setVisible(true);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	
	private static JPanel getWallComponent()
    {
        JPanel panel = new JPanel();

        panel.setBackground(Color.black);
        panel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        panel.setSize(new Dimension(50, 50)); // for demo purposes only
        
        return panel;
    }
	
	class exitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
	public class viewMenuListener  implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			homeMenu.setSelected(false);
			viewMenu.setSelected(true);
			if(viewMenu.isSelected()){
				frame.remove(toolPanel);			}
		}
	}
	
	public class homeMenuListener  implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			

		}
	}

	public class pasteListener     implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			pad.paste();
		}
		
	}
	
	public class cutListener       implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class copyListener      implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class selectListener    extends MouseAdapter{
		Graphics2D graphic ;
		
	
		public void actionPerformed(ActionEvent arg0) {
			//pad.
		}
		
	}
	
	public class cropListener      implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class resizeListener    implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class rotateListener    implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class pencilListener    implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class fillListener      implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// 
			
		}
		
	}
	
	public class textListener      implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class eraserListener    implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class dropperListener   implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class zoomListener      implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class brushListener     implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class outlineListener   implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class fillshapeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class BrushsizeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class drawPad extends JComponent{
			Image image;
			Graphics2D graphics2D;
			int currentX, currentY, oldX, oldY;
			
			public drawPad(){
				
				setDoubleBuffered(false);
				addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent e){
						oldX = e.getX();
						oldY = e.getY();		        
					}
					public void mouseEntered(MouseEvent e){
						setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
					}
				});
				addMouseMotionListener(new MouseMotionAdapter(){
					public void mouseDragged(MouseEvent e){
						currentX = e.getX();
						currentY = e.getY();
						if(graphics2D!=null){
							graphics2D.drawLine(oldX, oldY, currentX, currentY);
						}
						repaint();
						oldX = currentX;
						oldY = currentY;
					}
				});
			}
			public void paintComponent(Graphics g) {
			    if (image == null) {
			      image = createImage(getSize().width, getSize().height);
			      graphics2D = (Graphics2D) image.getGraphics();
			      graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			          RenderingHints.VALUE_ANTIALIAS_ON);
			      clear();
			    }
			    g.drawImage(image, 0, 0, null);
			  }

			  public void clear() {
			    graphics2D.setPaint(Color.white);
			    graphics2D.fillRect(0, 0, getSize().width, getSize().height);
			    graphics2D.setPaint(Color.black);
			    repaint();
			  }
			}
	
	
public static void main(String []args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	javax.swing.SwingUtilities.invokeLater( new Runnable(){
		public void run() {
			Painting p = new Painting();

		}
	});
  }
}