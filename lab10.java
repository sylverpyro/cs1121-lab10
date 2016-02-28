// Stacy Auger, Michael Benson
// Section 10
// Lab 10

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab10 extends JApplet implements ActionListener {

    // constants
    private final int maxValues = 10;

    // property variables
    private JLabel msg1 = new JLabel("Enter a number: ", SwingConstants.RIGHT);
    private JTextField input = new JTextField(20);
    private JLabel msg2 = new JLabel("Contents: ", SwingConstants.RIGHT);
    private JLabel contents = new JLabel("");
    private JLabel empty = new JLabel("");
    private JButton dup = new JButton("duplicate maximum value");

    private int [] data = new int[maxValues];
    private int [] temp = new int[maxValues];
    private int count = 0;
	
    public void init() {

	Container window = getContentPane();
	window.setLayout(new GridLayout(3,2));

	// add the buttons and labels
	window.add(msg1);
	window.add(input);
	window.add(msg2);
	window.add(contents);
	window.add(empty);
	window.add(dup);

	// attach the Listeners
	input.addActionListener(this);
	dup.addActionListener(this);

        } // end of init method

    public void actionPerformed(ActionEvent event) {
	
	if (event.getSource() == dup && count < maxValues) {
	    duplicate();
	    }
	
	else if (count < maxValues) {
	    data[count] = Integer.parseInt(input.getText());
	    count += 1;
	    showAll();
	    }
	input.setText("");
	
	} // end of ActionPerformed method

    private void showAll() {

	String all = data[0] + "";
	for (int i=1; i < count; i++) {
	    all = all + ", " + data[i];
	    }
	contents.setText(all);  
	} // end of showAll method

    private void duplicate() {
	
	int big = 0;
	int i = 0;
	int x = 0;
	for (;i < count ;) {	    
	  if (data[i] > big) {
		big = data[i];
		x = i;
	      }
	  i++;
	  }
	
	for (int t=0; t < 10 ; t++) {
	    temp[t] = data[t];
	    }
	
	data[x+1] = big;
	x = x+2;
	count++;
		
	for (; x < count; x++) {
	    data[x] = temp[x-1];
	    }
	showAll();
	
	} // end of duplicate method

    } // end of lab10 class
