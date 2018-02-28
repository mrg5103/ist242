/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizzes;

/**
 *
 * @author mrg5103
 */
public class Question 
{
protected String text;
protected String answer;

public Question()
{
    text = "";
    answer = "";
}

public Question(String t)
{
    text = t;
    
}

public void setText(String t)
{
    text = t;
}

public void setAnswer (String a)
{
    answer = a;
}
    
public boolean checkAnswer(String response)
{
    return answer.equals(response);
}
public void display()
{
    System.out.println(text);
}


        


}
