package learningtool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Match extends JPanel {
    JButton goback,mb;
    String letter;
    ImageIcon img;
    JLabel menu1,menu2,menu3;
    int goSign=0;
    

    public Match(String letter){
        super(new BorderLayout());
        
         /*Initialize Components*/
        
        
        goback = new JButton("Go Back");
        goback.setBounds(50, 50, 50, 50);
        mb = new JButton("Match");
       // mb.setBounds(50, 50, 50, 50);
        goback.setPreferredSize(new Dimension(150, 50));
        mb.setPreferredSize(new Dimension(150, 50));
        

        
        this.letter = letter;
        if("shoreo".equals(letter)||"shorea".equals(letter)||"shorte".equals(letter)||"longe".equals(letter)||"shortu".equals(letter)||"longu".equals(letter)||"hrii".equals(letter)||"ae".equals(letter)||"oii".equals(letter)||"oo".equals(letter)||"oou".equals(letter)){
            goSign=1;
        }
        
        img = new ImageIcon(new ImageIcon(letter+".png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        menu3 = new JLabel("",SwingConstants.CENTER);
        menu3.setIcon(img);
        menu3.setOpaque(true);
        menu3.setBounds(100, 100, 300, 300);
        menu3.setBorder(new EmptyBorder(25,0,0,0));
        
        img = new ImageIcon(new ImageIcon(letter+"1.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        //img = new ImageIcon(letter+"1.jpg");
        menu1 = new JLabel("");
        menu1.setIcon(img);
        menu1.setOpaque(true);
        menu1.setBounds(0, 0, 300, 300);
        menu1.setBorder(new EmptyBorder(0,50,0,0));
        
        img = new ImageIcon(new ImageIcon(letter+"2.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        menu2 = new JLabel("");
        menu2.setIcon(img);
        menu2.setOpaque(true);
        menu2.setBounds(0, 0, 300, 300);
        menu2.setBorder(new EmptyBorder(0,0,0,50));
        
        goback.setBackground(Color.RED);
        mb.setBackground(Color.RED);
        menu1.setBackground(Color.decode("#DBEA97"));
        menu2.setBackground(Color.decode("#DBEA97"));
        menu3.setBackground(Color.decode("#DBEA97"));
        setBackground(Color.decode("#DBEA97"));
        
        /*Adding Components*/
        add(goback,BorderLayout.SOUTH);
        add(menu1,BorderLayout.WEST);
        add(menu2,BorderLayout.EAST);
        add(menu3,BorderLayout.NORTH);
        add(mb,BorderLayout.SOUTH);
        
        /* Setting Layout JPanel*/
        //setLayout(null);
        setLocation(0,0);
        setVisible(true);
        setSize(600, 500);
        
        mb.addActionListener((ActionEvent ae) -> {
            mb.setBackground(Color.red);
            mb.setText("Match");
            PortReader pr = new PortReader("COM4");
            matchSign(pr);
        });
        
        goback.addActionListener((ActionEvent e) -> {
            if(goSign==1){
            LearningTool.main.matchJPanel.setVisible(false);
            LearningTool.main.jf.setContentPane(LearningTool.main.learnJPanel);
            LearningTool.main.learnJPanel.setVisible(true);
            }
            else{
               LearningTool.main.matchJPanel.setVisible(false);
            LearningTool.main.jf.setContentPane(LearningTool.main.learnbJPanel);
            LearningTool.main.learnbJPanel.setVisible(true);  
            }
        });
    }
    
    public void matchSign(PortReader pr){
        boolean matched = false; 
        int count = 0;
        while(matched==false && count<10){
                pr.readPort();
                if (pr.thumb>=90 && pr.thumb<=160 && pr.index>=130 && pr.index<=190 && pr.middle>=180 && pr.middle<=230 && pr.ring>=140 && pr.ring<=180 && pr.little>=120 && pr.little<=180 && letter.equals("shoreo"))
                    matched= true;
                    //System.out.println("shoreo");
                if (pr.thumb>=0 && pr.thumb<=100 && pr.index>=45 && pr.index<=85 && pr.middle>=60 && pr.middle<=100 && pr.ring>=40 && pr.ring<=80 && pr.little>=80 && pr.little<=120 && letter.equals("shorea"))
                  matched = true;
                  //System.out.println("shorea");
                if (pr.thumb>=140 && pr.thumb<=220 && pr.index>=145 && pr.index<=195 && pr.middle>=220 && pr.middle<=280 && pr.ring>=210 && pr.ring<=250 && pr.little>=215 && pr.little<=255 && letter.equals("shorte"))
                  matched = true;
                  //System.out.println("short e");
                if (pr.thumb>=140 && pr.thumb<=220 && pr.index>=145 && pr.index<=195 && pr.middle>=220 && pr.middle<=280 && pr.ring>=210 && pr.ring<=250 && pr.little>=215 && pr.little<=255 && letter.equals("longe"))
                  matched = true;
                  //System.out.println("short e");
                if (pr.thumb>=125 && pr.thumb<=165 && pr.index>=40 && pr.index<=100 && pr.middle>=190 && pr.middle<=230 && pr.ring>=205 && pr.ring<=245 && pr.little>=210 && pr.little<=250 && letter.equals("shortu"))
                  matched = true;
                  //System.out.println("short u");
                if (pr.thumb>=125 && pr.thumb<=165 && pr.index>=40 && pr.index<=100 && pr.middle>=190 && pr.middle<=230 && pr.ring>=205 && pr.ring<=245 && pr.little>=210 && pr.little<=250 && letter.equals("longu"))
                  matched = true;
                  //System.out.println("short u");
                if (pr.thumb>=130 && pr.thumb<=180 && pr.index>=55 && pr.index<=95 && pr.middle>=70 && pr.middle<=110 && pr.ring>=210 && pr.ring<=250 && pr.little>=180 && pr.little<=220 && letter.equals("hrii"))
                  matched = true;
                 if (pr.thumb>=130 && pr.thumb<=180 && pr.index>=55 && pr.index<=95 && pr.middle>=70 && pr.middle<=110 && pr.ring>=210 && pr.ring<=250 && pr.little>=180 && pr.little<=220 && letter.equals("ro"))
                  matched = true;
                  if (pr.thumb>=130 && pr.thumb<=180 && pr.index>=55 && pr.index<=95 && pr.middle>=70 && pr.middle<=110 && pr.ring>=210 && pr.ring<=250 && pr.little>=180 && pr.little<=220 && letter.equals("rro"))
                  matched = true;
                   if (pr.thumb>=130 && pr.thumb<=180 && pr.index>=55 && pr.index<=95 && pr.middle>=70 && pr.middle<=110 && pr.ring>=210 && pr.ring<=250 && pr.little>=180 && pr.little<=220 && letter.equals("rrro"))
                  matched = true;
                
                  //System.out.println("hrii");
                if (pr.thumb>=55 && pr.thumb<=95 && pr.index>=220 && pr.index<=260 && pr.middle>=260 && pr.middle<=300 && pr.ring>=225 && pr.ring<=265 && pr.little>=210 && pr.little<=250 && letter.equals("ae"))
                  matched = true;
                  //System.out.println("ae");
                if (pr.thumb>=50 && pr.thumb<=90 && pr.index>=195 && pr.index<=235 && pr.middle>=225 && pr.middle<=265 && pr.ring>=180 && pr.ring<=220 && pr.little>=100 && pr.little<=150 && letter.equals("oii"))
                  matched = true;
                  //System.out.println("oi");
                if (pr.thumb>=190 && pr.thumb<=230 && pr.index>=185 && pr.index<=225 && pr.middle>=225 && pr.middle<=265 && pr.ring>=190 && pr.ring<=230 && pr.little>=200 && pr.little<=240 && letter.equals("oo"))
                  matched = true;
                  //System.out.println("o");
                if (pr.thumb>=170 && pr.thumb<=210 && pr.index>=170 && pr.index<=210 && pr.middle>=225 && pr.middle<=265 && pr.ring>=180 && pr.ring<=220 && pr.little>=120 && pr.little<=180 && letter.equals("oou"))
                  matched = true;
                  //System.out.println("ou");
                if (pr.thumb>=165 && pr.thumb<=220 && pr.index>=190 && pr.index<=230 && pr.middle>=225 && pr.middle<=265 && pr.ring>=195 && pr.ring<235 && pr.little>=180 && pr.little<=220 && letter.equals("ko"))
                  matched = true;
                  //System.out.println("ko");
                if (pr.thumb>=40 && pr.thumb<=100 && pr.index>=185 && pr.index<=225 && pr.middle>=220 && pr.middle<=260 && pr.ring>=200 && pr.ring<=240 && pr.little>=190 && pr.little<=230 && letter.equals("kho"))
                  matched = true;
                  //System.out.println("kho");
                if (pr.thumb>=120 && pr.thumb<=160 && pr.index>=85 && pr.index<=125 && pr.middle>=125 && pr.middle<=225 && pr.ring>=80 && pr.ring<=120 && pr.little>=60 && pr.little<=140 && letter.equals("go"))
                  matched = true;
                  //System.out.println("go");
                if (pr.thumb>=150 && pr.thumb<=205 && pr.index>=130 && pr.index<=180 && pr.middle>=215 && pr.middle<=255 && pr.ring>=210 && pr.ring<=250 && pr.little>=195 && pr.little<=235 && letter.equals("gho"))
                  matched = true;
                  //System.out.println("gho");
                if (pr.thumb>=45 && pr.thumb<=85 && pr.index>=195 && pr.index<=235 && pr.middle>=105 && pr.middle<=145 && pr.ring>=65 && pr.ring<=105 && pr.little>=60 && pr.little<=100 && letter.equals("umo"))
                  matched = true;
                  //System.out.println("umo");
                if (pr.thumb>=175 && pr.thumb<=215 && pr.index>=185 && pr.index<=225 && pr.middle>=80 && pr.middle<=120 && pr.ring>=35 && pr.ring<=75 && pr.little>=50 && pr.little<=90 && letter.equals("cho"))
                  matched = true;
                  //System.out.println("cho");
                if (pr.thumb>=140 && pr.thumb<=180 && pr.index>=60 && pr.index<=120 && pr.middle>=205 && pr.middle<=245 && pr.ring>=190 && pr.ring<=230 && pr.little>=65 && pr.little<=135 && letter.equals("chho"))
                  matched = true;
                  //System.out.println("chho");
                if (pr.thumb>=150 && pr.thumb<=210 && pr.index>=190 && pr.index<=230 && pr.middle>=220 && pr.middle<=260 && pr.ring>=200 && pr.ring<=240 && pr.little>=190 && pr.little<=230 && letter.equals("jo"))
                  matched = true;
                  //System.out.println("jo");
                   if (pr.thumb>=150 && pr.thumb<=210 && pr.index>=190 && pr.index<=230 && pr.middle>=220 && pr.middle<=260 && pr.ring>=200 && pr.ring<=240 && pr.little>=190 && pr.little<=230 && letter.equals("ojo"))
                  matched = true;
                if (pr.thumb>=50 && pr.thumb<=95 && pr.index>=30 && pr.index<=80 && pr.middle>=60 && pr.middle<=100 && pr.ring>=195 && pr.ring<=245 && pr.little>=195 && pr.little<=235 && letter.equals("jho"))
                  matched = true;
                  //System.out.println("jho");
                if (pr.thumb>145 && pr.thumb<=185 && pr.index>=160 && pr.index<=200 && pr.middle>=100 && pr.middle<=140 && pr.ring>=55 && pr.ring<=95 && pr.little>=35 && pr.little<=75 && letter.equals("neo"))
                  matched = true;
                  //System.out.println("neo");
                if (pr.thumb>=160 && pr.thumb<=200 && pr.index>=135 && pr.index<=175 && pr.middle>=190 && pr.middle<=230 && pr.ring>=220 && pr.ring<=260 && pr.little>=195 && pr.little<=235 && letter.equals("tto"))
                  matched = true;
                  //System.out.println("tto");
                if (pr.thumb>=130 && pr.thumb<=170 && pr.index>=130 && pr.index<=170 && pr.middle>=200 && pr.middle<=240 && pr.ring>=205 && pr.ring<=245 && pr.little>=180 && pr.little<=220 && letter.equals("ttho"))
                  matched = true;
                  //System.out.println("ttho");
                if (pr.thumb>=40 && pr.thumb<=90 && pr.index>=40 && pr.index<=80 && pr.middle>=70 && pr.middle<=110 && pr.ring>=180 && pr.ring<=240 && pr.little>=170 && pr.little<=210 && letter.equals("ddo"))
                  matched = true;
                  //System.out.println("ddo");
                if (pr.thumb>=155 && pr.thumb<=195 && pr.index>=40 && pr.index<=80 && pr.middle>=210 && pr.middle<=255 && pr.ring>=195 && pr.ring<=235 && pr.little>=145 && pr.little<=195 && letter.equals("ddho"))
                  matched = true;
                  //System.out.println("ddho");
                if (pr.thumb>=115 && pr.thumb<=155 && pr.index>=160 && pr.index<=200 && pr.middle>=185 && pr.middle<=225 && pr.ring>=60 && pr.ring<=210 && pr.little>=30 && pr.little<=80 && letter.equals("no"))
                  matched = true;
                   if (pr.thumb>=115 && pr.thumb<=155 && pr.index>=160 && pr.index<=200 && pr.middle>=185 && pr.middle<=225 && pr.ring>=60 && pr.ring<=210 && pr.little>=30 && pr.little<=80 && letter.equals("mono"))
                  matched = true;

                  //System.out.println("no");
                if (pr.thumb>=230 && pr.thumb<=270 && pr.index>=175 && pr.index<=215 && pr.middle>=220 && pr.middle<=260 && pr.ring>=220 && pr.ring<=260 && pr.little>=195 && pr.little<=235 && letter.equals("to"))
                  matched = true;
                
                   if (pr.thumb>=230 && pr.thumb<=270 && pr.index>=175 && pr.index<=215 && pr.middle>=220 && pr.middle<=260 && pr.ring>=220 && pr.ring<=260 && pr.little>=195 && pr.little<=235 && letter.equals("khoto"))
                  matched = true;
                  //System.out.println("to");
                if (pr.thumb>=60 && pr.thumb<=100 && pr.index>=65 && pr.index<=85 && pr.middle>=160 && pr.middle<=200 && pr.ring>=185 && pr.ring<=225 && pr.little>=170 && pr.little<=210 && letter.equals("tho"))
                  matched = true;
                  //System.out.println("tho");
                if (pr.thumb>=35 && pr.thumb<=90 && pr.index>=190 && pr.index<=230 && pr.middle>=200 && pr.middle<=240 && pr.ring>=210 && pr.ring<=250 && pr.little>=180 && pr.little<=220 && letter.equals("do"))
                  matched = true;
                  //System.out.println("do");
                if (pr.thumb>=170 && pr.thumb<=230 && pr.index>=210 && pr.index<=250 && pr.middle>=230 && pr.middle<=270 && pr.ring>=220 && pr.ring<=260 && pr.little>=210 && pr.little<=250 && letter.equals("dho"))
                  matched = true;
                  //System.out.println("dho");
                if (pr.thumb>=180 && pr.thumb<=240 && pr.index>=65 && pr.index<=115 && pr.middle>=120 && pr.middle<=160 && pr.ring>=200 && pr.ring<=250 && pr.little>=190 && pr.little<=240 && letter.equals("po"))
                  matched = true;
                  //System.out.println("po");
                if (pr.thumb>=155 && pr.thumb<=195 && pr.index>=195 && pr.index<=225 && pr.middle>=90 && pr.middle<=130 && pr.ring>=35 && pr.ring<=75 && pr.little>=60 && pr.little<=100 && letter.equals("pho"))
                  matched = true;
                  //System.out.println("pho");
                if (pr.thumb>=200 && pr.thumb<=250 && pr.index>=45 && pr.index<=90 && pr.middle>=80 && pr.middle<=120 && pr.ring>40 && pr.ring<=80 && pr.little>=50 && pr.little<=90 && letter.equals("bo"))
                  matched = true;
                  if (pr.thumb>=220 && pr.thumb<=300 && pr.index>=70 && pr.index<=110 && pr.middle>=100 && pr.middle<=140 && pr.ring>=60 && pr.ring<=100 && pr.little>=70 && pr.little<=120 && letter.equals("bho"))
                  matched = true;
                  //System.out.println("bo");
                if (pr.thumb>=155 && pr.thumb<=200 && pr.index>=70 && pr.index<=110 && pr.middle>=100 && pr.middle<=145 && pr.ring>=80 && pr.ring<=120 && pr.little>=175 && pr.little<=235 && letter.equals("mo"))
                  matched = true;
                  //System.out.println("mo");
                if (pr.thumb>=35 && pr.thumb<=75 && pr.index>=30 && pr.index<=70 && pr.middle>=195 && pr.middle<=235 && pr.ring>=180 && pr.ring<=23 && pr.little>=170 && pr.little<=210 && letter.equals("lo"))
                  matched = true;
                  //System.out.println("lo");
                if (pr.thumb>=205 && pr.thumb<=245 && pr.index>=210 && pr.index<=250 && pr.middle>=240 && pr.middle<=280 && pr.ring>=225 && pr.ring<=265 && pr.little>=200 && pr.little<=240 && letter.equals("sho"))
                  matched = true;
                 if (pr.thumb>=205 && pr.thumb<=245 && pr.index>=210 && pr.index<=250 && pr.middle>=240 && pr.middle<=280 && pr.ring>=225 && pr.ring<=265 && pr.little>=200 && pr.little<=240 && letter.equals("ssho"))
                  matched = true;
                  if (pr.thumb>=205 && pr.thumb<=245 && pr.index>=230 && pr.index<=270 && pr.middle>=260 && pr.middle<=300 && pr.ring>=225 && pr.ring<=265 && pr.little>=200 && pr.little<=250 && letter.equals("sssho"))
                  matched = true;
                  //System.out.println("sho");
                if (pr.thumb>=180 && pr.thumb<=220 && pr.index>=25 && pr.index<=75 && pr.middle>=50 && pr.middle<=90 && pr.ring>=200 && pr.ring<=250 && pr.little>=180 && pr.little<=220 && letter.equals("ho"))
                  matched = true;
                  //System.out.println("ho");
                if (pr.thumb>=80 && pr.thumb<=150 && pr.index>=50 && pr.index<=120 && pr.middle>=220 && pr.middle<=260 && pr.ring>=205 && pr.ring<=245 && pr.little>=160 && pr.little<=205 && letter.equals("onu"))
                  matched = true;
                  //System.out.println("onu");
                if (pr.thumb>=45 && pr.thumb<=100 && pr.index>=100 && pr.index<=150 && pr.middle>=205 && pr.middle<=245 && pr.ring>=195 && pr.ring<=235 && pr.little>=210 && pr.little<=250 && letter.equals("bindu"))
                  matched = true;
                  //System.out.println("bindu");

                  //System.out.println("bindu");
                    count++;
            }
        if (matched==true){
            mb.setBackground(Color.green);
            mb.setText("Matched!");
        }
        else{
            mb.setBackground(Color.blue.brighter());
            mb.setText("NOT Matched!");  
        }
    }
}
