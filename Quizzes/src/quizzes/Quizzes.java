/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizzes;

import java.util.Scanner;

/**
 *
 * @author mrg5103
 */
public class Quizzes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question q1 = new Question();
        q1.setText("Who was the inventor of Java?");
        q1.setAnswer("James Gosling");
        
        
        ChoiceQuestion q2 = new ChoiceQuestion();
        q2.setText("What country is the inventor of Java from?");
        q2.addChoice("USA", false);
        q2.addChoice("Germany", false);
        q2.addChoice("Canada", true);
        q2.addChoice("Netherlands", false);
        
        presentQuestion(q2);
        
        q2.display();
        System.out.print("Your Answer: ");
        String response = sc.nextLine();
        System.out.println(q2.checkAnswer(response));
        /*
        q1.display();
        System.out.print("Your Answer: ");
        String response = sc.nextLine();
        System.out.println(q1.checkAnswer(response));
*/
    }
    
    public static void presentQuestion(Question q)
    {
        Scanner sc2 = new Scanner(System.in);
        q.display();
        System.out.print("Your Answer: ");
        String response = sc2.nextLine();
        System.out.println(q.checkAnswer(response));
    }
    
}
