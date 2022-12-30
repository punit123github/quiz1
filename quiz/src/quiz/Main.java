package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.ArrayList;

public class Main {
  static int count = 0;
  public static void main(String[] args) {
    List<Answer> l1 = new ArrayList<>();
    Map<Question, List<Answer>> m = new HashMap();
   

    try {

      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/quiz", "root", "root");
      PreparedStatement statement = con.prepareStatement(
          "select q.ques,a.quesid,a.Answer,a.ansid,a.choice,a.isRight from"
          + " Question q join Answer a on q.quesid=a.quesid order by a.quesid;");
      ResultSet rs = statement.executeQuery();
      int ab= 1;
      // System.out.println(rs.getFetchSize());

      while (rs.next()) {
        
        if (ab == 4) {
          Answer as = new Answer(rs.getLong("ansid"), rs.getString("answer"),
              rs.getLong("quesid"), rs.getBoolean("isRight"),
              rs.getString("choice"));
          l1.add(as);

          Question qs =
              new Question(rs.getLong("quesid"), rs.getString("ques"));
         
          m.put(qs, l1);
          l1 = new ArrayList();
          ab = 1;
          continue;
        } else {
          Answer as = new Answer(rs.getLong("ansid"), rs.getString("answer"),
              rs.getLong("quesid"), rs.getBoolean("isRight"),
              rs.getString("choice"));
          l1.add(as);
        }
        ab++;
      }

      for (int i = 1; i <= 5; i++) {
    	  
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name");
        String userName = sc.next();
        System.out.println("Enter Your Email");
        String userEmail = sc.next();
        for (Map.Entry<Question, List<Answer>> entry : m.entrySet()) {
          System.out.println(entry.getKey().getQues());
          // System.out.println(entry.getValue());
          Iterator<Answer> answerItr = entry.getValue().iterator();
          
          while (answerItr.hasNext()) {
            System.out.println("a: " + answerItr.next().getAnswer());
            System.out.println("b: " + answerItr.next().getAnswer());
            System.out.println("c: " + answerItr.next().getAnswer());
            System.out.println("d: " + answerItr.next().getAnswer());
          }

          System.out.println("Enter your Answer");
          String userChoice = sc.next();

          Iterator<Answer> i1 = entry.getValue().iterator();
          Boolean isRight = false;

          while (i1.hasNext()) {
            Answer answer = i1.next();
            if (answer.getChoice().equalsIgnoreCase(userChoice) && answer.getIsright()) {
              isRight = true;
            }
          }

          if (isRight) {
            count++;
          }
          System.out.println();
        }

        System.out.println("Your Final Score IS:" + count);
        if(count>8)
        	System.out.println("class A");
        else if(count>6 && count<8)
        	System.out.println("class B");
        else if(count==5)
        	System.out.println("class C");
        else
        	System.out.println("class D");


       
        //statement.close();
        //rs.close();
        statement= con.prepareStatement("insert into User(User_name,User_email,Quiz_score) values "
        		+ "('"+userName+"','"+userEmail+"',"+count+")");
            statement.executeUpdate();
            System.out.println();
            System.out.println("To Countinue Press 1 or To EXIT Press 2");
            int userSelection = sc.nextInt();
            if(userSelection==2)
            	break;
            count=0;
      }

    }
   
    catch (Exception e) {
      System.out.println(e);
    }
    // System.out.println(m);
  }
}
