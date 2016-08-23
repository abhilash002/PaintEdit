import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.colorchooser.AbstractColorChooserPanel;

class colorChooser extends AbstractColorChooserPanel implements ActionListener{
	JToggleButton black,darkgray,darkred,red,orange,yellow,green,turquoise,indigo,purple,
				  white,lightgray,brown,rose,gold,lightyellow,lime,lightturquoise,bluegray,
				  lavender,sel1,sel2,sel3,sel4,sel5,sel6,sel7,sel8,sel9,sel0;
	Color darkredc = new Color(175,0,0);
	Color turquoisec = new Color(0, 162, 232);
	Color purplec = new Color(163,74, 164);
	Color indigoc = new Color(63, 72,204);
	Color brownc = new Color(185,122,87);
	Color rosec = new Color(255, 174, 201);
	Color goldc = new Color(255, 201, 14);
	Color lightyellowc = new Color(239, 228, 176);
	Color limec = new Color(181,230,29);
	Color lightturquoisec = new Color(153,217,234);
	Color bluegrayc = new Color(112,146,190);
	Color lavenderc = new Color(200,191,231);
    private JColorChooser tcc;

	@Override
	public void actionPerformed(ActionEvent e) {
		Color newColor = null;
        String command = ((JToggleButton)e.getSource()).getActionCommand();
        if ("green".equals(command))
            newColor = Color.green;
        else if ("red".equals(command))
            newColor = Color.red;
        else if ("yellow".equals(command))
            newColor = Color.yellow;
        else if ("black".equals(command))
            newColor = Color.black;
        else if ("orange".equals(command))
            newColor = Color.orange;
        else if ("turquoise".equals(command))
            newColor = turquoisec;
        else if ("indigo".equals(command))
            newColor = indigoc;
        else if ("purple".equals(command))
            newColor = purplec;
        else if ("white".equals(command))
            newColor = Color.white;
        else if ("lightgray".equals(command))
            newColor = Color.lightGray;
        else if ("brown".equals(command))
            newColor = brownc;
        else if ("rose".equals(command))
            newColor = rosec;
        else if ("gold".equals(command))
            newColor = goldc;
        else if ("lightyellow".equals(command))
            newColor = lightyellowc;
        else if ("lime".equals(command))
            newColor = limec;
        else if ("lightturquoise".equals(command))
            newColor = lightturquoisec;
        else if ("bluegray".equals(command))
            newColor = bluegrayc;
        else if ("lavender".equals(command))
            newColor = lavenderc;
        else if ("darkgray".equals(command))
            newColor = Color.darkGray;
        else if ("darkred".equals(command))
            newColor = darkredc;

        getColorSelectionModel().setSelectedColor(newColor);
	}
			
	protected JToggleButton createCrayon(String name,
            Border normalBorder) {
			JToggleButton crayon = new JToggleButton();
			crayon.setActionCommand(name);
			crayon.addActionListener(this);
			return crayon;
	}
	protected void buildChooser() {
		setLayout(new GridLayout(10,3));
		ButtonGroup colorGroup = new ButtonGroup();
		Border border = BorderFactory.createEmptyBorder(1,1,1,1);
		
		black = createCrayon("black",border);
		colorGroup.add(black);
		add(black);
		darkgray = createCrayon("darkgray",border);
		colorGroup.add(darkgray);
		add(darkgray);
		darkgray= createCrayon("darkred",border);
		colorGroup.add(darkred);
		add(darkred);
		red= createCrayon("red",border);
		colorGroup.add(red);
		add(red);
		orange= createCrayon("orange",border);
		colorGroup.add(orange);
		add(orange);
		yellow= createCrayon("yellow",border);
		colorGroup.add(yellow);
		add(yellow);
		green= createCrayon("green",border);
		colorGroup.add(green);
		turquoise= createCrayon("turquoise",border);
		colorGroup.add(turquoise);
		indigo= createCrayon("indigo",border);
		colorGroup.add(indigo);
		purple= createCrayon("purple",border);
		colorGroup.add(purple);
		white= createCrayon("white",border);
		colorGroup.add(white);
		lightgray= createCrayon("lightgray",border);
		colorGroup.add(lightgray);
		brown= createCrayon("brown",border);
		colorGroup.add(brown);
		rose= createCrayon("rose",border);
		colorGroup.add(rose);
		gold= createCrayon("gold",border);
		colorGroup.add(gold);
		lightyellow= createCrayon("lightyellow",border);
		colorGroup.add(lightyellow);
		lime= createCrayon("lime",border);
		colorGroup.add(lime);
		lightturquoise= createCrayon("lightturquoise",border);
		colorGroup.add(lightturquoise);
		bluegray= createCrayon("bluegray",border);
		colorGroup.add(bluegray);
		lavender= createCrayon("lavender",border);
		colorGroup.add(lavender);
		
	}

	@Override
	public String getDisplayName() {
		return null;
	}

	@Override
	public Icon getLargeDisplayIcon() {
		return null;
	}

	@Override
	public Icon getSmallDisplayIcon() {
		return null;
	}

	@Override
	public void updateChooser() {
		Color color = getColorFromModel();
        if (Color.black.equals(color)) {
        	black.setSelected(true);
        }else if(Color.DARK_GRAY.equals(color)){
        	darkgray.setSelected(true);
        }else if(darkredc.equals(color)){
        	darkred.setSelected(true);
        }else if(Color.red.equals(color)){
        	red.setSelected(true);
        }else if(Color.orange.equals(color)){
        	orange.setSelected(true);
        }else if(Color.yellow.equals(color)){
        	yellow.setSelected(true);
        }else if(Color.green.equals(color)){
        	green.setSelected(true);
        }else if(turquoisec.equals(color)){
        	turquoise.setSelected(true);
        }else if(indigoc.equals(color)){
        	indigo.setSelected(true);
        }else if(purplec.equals(color)){
        	purple.setSelected(true);
        }else if(Color.white.equals(color)){
        	white.setSelected(true);
        }else if(Color.lightGray.equals(color)){
        	lightgray.setSelected(true);
        }else if(brownc.equals(color)){
        	brown.setSelected(true);
        }else if(rosec.equals(color)){
        	rose.setSelected(true);
        }else if(goldc.equals(color)){
        	gold.setSelected(true);
        }else if(lightyellowc.equals(color)){
        	lightyellow.setSelected(true);
        }else if(limec.equals(color)){
        	lime.setSelected(true);
        }else if(lightturquoisec.equals(color)){
        	lightturquoise.setSelected(true);
        }else if(bluegrayc.equals(color)){
        	bluegray.setSelected(true);
        }else if(lavenderc.equals(color)){
        	lavender.setSelected(true);
        }
	}
	
	public static void main(String[] args) {
		colorChooser cc = new colorChooser();
	    JColorChooser tcc = new JColorChooser();

		JPanel panel = new JPanel();
	    tcc.setPreviewPanel(new JPanel());
	    AbstractColorChooserPanel panels[] = { new colorChooser() };
		tcc.setChooserPanels(panels);
		add(panel, BorderLayout.CENTER);
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            }
        });
    }
}