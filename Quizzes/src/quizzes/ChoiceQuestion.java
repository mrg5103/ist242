/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizzes;

import java.util.ArrayList;

/**
 *
 * @author mrg5103
 */
public class ChoiceQuestion extends Question
{
    String choiceString;
    int choiceNumber = 0;
 private ArrayList<String> choices;
 
 public ChoiceQuestion()
 {
    choices = new ArrayList<>();
 }
 
 public ChoiceQuestion(String t)
 {
     super(t);
     choices = new ArrayList<>();
 }
 public void addChoice(String choice, boolean correct)
 {
     choices.add(choice);
     if (correct)
     {
         choiceString = "" + choices.size();
         setAnswer(choiceString);
    }
 }
 public void display()
 {
     super.display();
     for (int i=0; i<choices.size(); i++)
     {
         choiceNumber = i+1;
     }
 }
 
}
