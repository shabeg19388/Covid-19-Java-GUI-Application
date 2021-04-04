package generics;

/*NAME-Shabeg Singh Gill
Roll N0- 2019388
Branch - CSSS
*/

import java.util.*;
import java.util.Scanner;
import java.lang.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.Date;
import java.awt.Color;
import java.awt.Graphics;


class AP4 {


    public static void main(String[] args) {
        Scanner s;
        s=new Scanner(System.in);
        covid obj =new covid();
    }
}

class Patient{
    public  String name ;
    public  int age ;
    public  char tower ;
    public  String repdate;
    public  String recdate;
    Date rep_date, rec_date;
    public Patient(String name, int age, char tower, String repdate, String recdate) {
        this.name=name;
        this.age=age;
        this.tower=tower;
        this.repdate=repdate;
        this.recdate=recdate;

        
        int day ;
        day= Integer.parseInt(repdate.substring(0,2));
        int month ;
        month= Integer.parseInt(repdate.substring(3,5))-1;
        int year;
        year= Integer.parseInt(repdate.substring(6,10));
        Calendar cal;
        cal= Calendar.getInstance();
        cal.set(year, month, day);
        this.rep_date = cal.getTime();

        day = Integer.parseInt(recdate.substring(0,2));
        month = Integer.parseInt(recdate.substring(3,5))-1;
        year = Integer.parseInt(recdate.substring(6,10));
        cal = Calendar.getInstance();
        cal.set(year, month, day);
        this.rec_date = cal.getTime();
    }
}

class covid extends JFrame implements ActionListener{
	
	JLabel jl1;
    JTextField f1;// for entering repoting date
    JLabel jl2;

    JCheckBox cb1; //for checkbox A
    JCheckBox cb2; //for checkbox B
    JCheckBox cb3; //for checkbox C
    JCheckBox cb4; //for checkbox D

    JButton jb1; //button for OK
    JLabel l1; //label for RESULT
    JLabel l2;
    JLabel l3;
    
    JTable jta; //table for active 
    JTable jtr; //table for recovered
    JTable count_table; //table for recovered
    
    JScrollPane spac; //scroll pane for active 
    JScrollPane spre; //scroll pane for recovered 
    JScrollPane spcount; //scroll pane for recovered 
    
    JPanel jp; //jpanel 
    

    Patient p1=new Patient("Flora", 6, 'A', "01/04/2020", "22/04/2020");
    Patient p2=new Patient("Denys", 24, 'B', "01/04/2020", "22/04/2020");
    Patient p3 = new Patient("Jim", 42, 'C', "18/05/2020","08/06/2020" );
    Patient p4= new Patient("Hazel", 87, 'D', "23/06/2020", "14/07/2020");
    Patient p5=new Patient("Caery", 72, 'A', "01/06/2020", "22/06/2020");
    Patient p6 =new Patient("David", 7, 'B', "14/06/2020", "05/07/2020");
    Patient p7 =new Patient("Kevim", 37,'D', "05/06/2020", "26/06/2020" );
    Patient p8 =new Patient("Tom", 67,'D', "20/06/2020", "11/07/2020" );
    Patient p9 =new Patient("Bob", 74,'A', "04/07/2020", "25/07/2020" );
    Patient p10 =new Patient("Rachel", 48,'C', "24/07/2020", "14/08/2020" );
    Patient p11 =new Patient("Thomas", 21,'C', "11/06/2020", "02/07/2020" );
    Patient p12 =new Patient("Mary", 17,'D', "21/06/2020", "12/07/2020" );
    Patient p13 =new Patient("Smith", 89,'A', "07/08/2020", "28/08/2020" );
    Patient p14 =new Patient("Pearson", 47,'B', "04/06/2020", "25/06/2020" );
    Patient p15 =new Patient("Anderson", 62,'B', "27/07/2020", "17/08/2020" );
    Patient p16= new Patient("Johnson", 10, 'D', "01/08/2020", "22/08/2020");
    Patient p17 =new Patient("Robertz", 50,'A', "09/08/2020", "30/08/2020" );
    Patient p18 =new Patient("Julie", 86,'B', "02/05/2020", "23/05/2020" );
    Patient p19 =new Patient("Edith", 42,'D', "07/06/2020", "28/06/2020" );
    Patient p20 =new Patient("John", 95,'D', "01/06/2020", "22/06/2020" );


    Patient[] p= {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19 , p20};
    ArrayList<Patient> ac=new ArrayList<>(); //list for active 
    ArrayList<Patient> re=new ArrayList<>(); //list for recovered 


    public covid() {
    	
    
    	jl1=new JLabel("ENTER DATE(dd/mm/yyyy):");
    	jl1.setOpaque(true);
    	jl1.setBackground(Color.ORANGE);
    	
        f1=new JTextField(25); //for input //for reporting date
       
        jl2=new JLabel("SELECT TOWERS:");
        jl2.setOpaque(true);
        jl2.setBackground(Color.YELLOW);
        

        cb1=new JCheckBox("Tower A"); //tower a
        cb1.setBackground(Color.CYAN);
        cb1.setOpaque(true);
        
        cb2=new JCheckBox("Tower B"); //tower b
        cb2.setBackground(Color.CYAN);
        cb2.setOpaque(true);
        
        cb3=new JCheckBox("Tower C"); //tower c
        cb3.setBackground(Color.CYAN);
        cb3.setOpaque(true);
        
        cb4=new JCheckBox("Tower D"); //tower d
        cb4.setBackground(Color.CYAN);
        cb4.setOpaque(true);

        jb1=new JButton("OK"); //for executing OK
        
        add(jl1);
        add(f1);
        add(jl2);
        add(cb1);
        add(cb2);
        add(cb3);
        add(cb4);
        add(jb1);
 
        jb1.addActionListener(this);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(600, 600);
        setTitle("COVID-19 ANALYSER");
        setVisible(true);

    }

    public int activecases(String str , char t) throws ParseException {
    	
        //if present date is greater than or equal repdate but less than recdate, then case is active
        int active;
        active=0;
        
        // SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
        // Date d1=sdf.parse(str); //input date
        Calendar cal;
        cal= Calendar.getInstance();
        cal.set(2020, Integer.parseInt(str.substring(3,5))-1, Integer.parseInt(str.substring(0,2)));
        Date d1 ;
        d1= cal.getTime();
        int i;
        for(i =0; i<20; i++) {
            if(p[i].tower==t) {
                if(d1.compareTo(p[i].rep_date)>=0 && d1.compareTo(p[i].rec_date)<0) {
                    active++;
                    ac.add(p[i]);  //adding to active list 
                }
            }
        }
        return active;
    }

    public int recoveredcases(String str, char t) throws ParseException{
        //if input date is greater than or equal to recovery date, then recovered case++
        int recovered=0;
        // SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        // Date d1=sdf.parse(str);
        Calendar cal ;
        cal= Calendar.getInstance();
        cal.set(2020, Integer.parseInt(str.substring(3,5))-1, Integer.parseInt(str.substring(0,2)));
        Date d1 ;
        d1= cal.getTime();
        for(int j=0; j<20; j++) {
            if(p[j].tower==t) {
                if(d1.compareTo(p[j].rec_date)>=0 ) {
                    recovered++;
                    re.add(p[j]); //adding to recovered list 
                }
            }
        }
        return recovered;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {


        //to find- no of active cases, no of reported, patient details(name, age, recovery date)
        String str ;
        str=f1.getText();// entering date
       
        int act1;
        act1=0; //tower a active 
        int act2;
        act2=0; //tower b active 
        int act3;
        act3=0; //tower c active 
        int act4;
        act4=0; //tower d active 
        int rec1;
        rec1=0;  //tower a rec
        int rec2;
        rec2=0; //tower b rec 
        int rec3;
        rec3=0; //tower c rec
        int rec4;
        rec4=0; //tower d rec 
        
        ac=new ArrayList<>();
        re=new ArrayList<>();
        ArrayList<String[]> count_list= new ArrayList<String[]>();
        if(ae.getSource()==jb1) {

            if(cb1.isSelected()) { //tower a selected
                try {
                    act1=activecases(str,'A' );
                    rec1=recoveredcases(str, 'A');
                    String[] temp;
                    temp=new String[3];
                    temp[0]="A";
                    temp[1]=Integer.toString(act1);
                    temp[2]=Integer.toString(rec1);
                    count_list.add(temp);
                    System.out.println("A");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                
            }

            if(cb2.isSelected()) { //tower b selected
                try {

                    act2=activecases(str, 'B');
                    rec2= recoveredcases(str, 'B');
                    System.out.println("B");
                    String[] temp=new String[3];
                    temp[0]="B";
                    temp[1]=Integer.toString(act2);
                    temp[2]=Integer.toString(rec2);
                    count_list.add(temp);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
               
            }

            if(cb3.isSelected()) { //tower c selected
               
                try {
                    act3=activecases(str, 'C');
                    rec3= recoveredcases(str, 'C');
                    System.out.println("C");
                    String[] temp=new String[3];
                    temp[0]="C";
                    temp[1]=Integer.toString(act3);
                    temp[2]=Integer.toString(rec3);
                    count_list.add(temp);
                    
                } catch (ParseException e) {                }

            }

            if(cb4.isSelected()) { //tower d selected
                try {
                    act4= activecases(str, 'D');
                    rec4= recoveredcases(str, 'D');
                    System.out.println("D");
                    String[] temp=new String[3];
                    temp[0]="D";
                    temp[1]=Integer.toString(act3);
                    temp[2]=Integer.toString(rec3);
                    count_list.add(temp);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                
            }

        }
        // int finalact=act1+act2+act3+act4;
        // int finalrec=rec1+rec2+rec3+rec3;
        
        String[] cols= {"Name", "Age", "Tower", "Reporting_Date", "Recovery_Date"};
        String[][] recarr;
        recarr=new String[re.size()][5];
        String[][] actarr;
        actarr=new String[ac.size()][5];
        System.out.println(re.size()+" "+ac.size());
        
        //for active 
        int i;
        for(i=0; i<ac.size(); i++) {
        	String[]  t1;
        	t1=new String[5];
        	t1[0]=ac.get(i).name;
        	t1[1]=Integer.toString(ac.get(i).age);
        	t1[2]=String.valueOf(ac.get(i).tower);
        	t1[3]=ac.get(i).repdate;
        	t1[4]=ac.get(i).recdate;
            actarr[i]=t1;
            System.out.println(actarr[i][0]);
        }
        //for recovered 
        int j;
        for(j=0; j<re.size(); j++) {
        	String[] t2;
        	t2=new String[5];
        	t2[0]=re.get(j).name;
        	t2[1]=Integer.toString(re.get(j).age);
        	t2[2]=String.valueOf(re.get(j).tower);
        	t2[3]=re.get(j).repdate;
        	t2[4]=re.get(j).recdate;
            recarr[j]=t2;
            System.out.println(recarr[j][0]);
        }
        try{
            remove(spac);
            remove(spre);
            remove(spcount);
            // jp.remove(spac);
            // jp.remove(spcount);
            // jp.remove(spre);
            remove(l1);
            remove(l2);
            // remove(jp);
        }catch(Exception r){}

        //defining JTables
        jta=new JTable(actarr, cols);
        // jta.setBounds(30, 50, 200, 300);
        jtr=new JTable(recarr, cols);
        // jtr.setBounds(30, 50, 200, 300);
        String[][] count_arr;
        count_arr=new String[count_list.size()][3];
        int k ;
        for(k=0;k<count_list.size();k++){
            count_arr[i]=count_list.get(i);
        }
        String[] col={"Tower","Active Cases", "Recovered Cases"};
        count_table = new JTable(count_arr,col);
        // jp=new JPanel();
        
        jta.setPreferredScrollableViewportSize(jta.getPreferredSize());
        jta.setFillsViewportHeight(true);
        
        count_table.setPreferredScrollableViewportSize(count_table.getPreferredSize());
        count_table.setFillsViewportHeight(true);
        
        jtr.setPreferredScrollableViewportSize(jtr.getPreferredSize());
        jtr.setFillsViewportHeight(true);
        
        //defining scroll panes 
        spac=new JScrollPane(jta);
        spre=new JScrollPane(jtr);
        spcount=new JScrollPane(count_table);
        // jp=new JPanel();
        //setting bounds 

        spac.setBackground(Color.RED);
        spac.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "ACTIVE_DATA"));
        
        spre.setBackground(Color.GREEN);
        spre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "RECOVERED_Data"));
        
        spcount.setBackground(Color.GREEN);
        spcount.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "No of Cases-Active and Recovered"));

        add(spre);
        add(spac);
        add(spcount);
        pack();
        setSize(600,600);
        

    }
   
      
}