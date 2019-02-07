package com.example.administrator.randomcal;

import java.util.Random;
import java.util.StringTokenizer;

public class RandomAndCal {
    public String problem;
    public RandomAndCal(String inputProblem){
        setProblem(inputProblem);
    }
    public int  getRandomNum(){
        Random random = new Random();
        int num = random.nextInt(10);
        return num;
    }

    public char getRandomOperator(){
        Random random = new Random();
        String operatorStr = "+-×";
        char op = operatorStr.charAt(random.nextInt(operatorStr.length()));
        return op;
    }

    public String getProblem(){
        int num1, num2, num3;
        char op1, op2;
        StringBuilder sb = new StringBuilder();
        String problem;
        num1 = getRandomNum();
        num2 = getRandomNum();
        num3 = getRandomNum();
        op1 = getRandomOperator();
        op2 = getRandomOperator();
        sb.append(num1); sb.append(op1); sb.append(num2); sb.append(op2); sb.append(num3);
        problem = sb.toString();
        return problem;
    }

    public void setProblem(String inputProblem){
        problem = inputProblem;
    }

    public int calculate(){
        int numLength = 3;
        int opLength = 2;
        int opCount = 0;
        int numCount = 0;
        int number[];
        char operator[];
        int weight[];
        char ch;
        int weightTemp = 0;
        number = new int[numLength];
        operator = new char[opLength];
        weight = new int[opLength];
        for(int i = 0; i < problem.length(); i++){
            ch = problem.charAt(i);
            if(ch <= '9' && ch>= '0'){
                number[numCount++] = Integer.parseInt(String.valueOf(ch));
            }
            if(ch == '+' || ch == '-' || ch == '×'){
                switch (ch){
                    case '+':
                    case '-':
                        weightTemp = 1;
                        break;
                    case '×':
                        weightTemp = 2;
                        break;
                }
                if(opCount == 0 || weight[opCount-1] < weightTemp){
                    weight[opCount] = weightTemp;
                    operator[opCount] = ch;
                    opCount++;
                }else{
                    while(opCount > 0 && weight[opCount - 1] >= weightTemp){
                        switch (operator[opCount - 1]){
                            case '+':
                                number[numCount - 2] += number[numCount - 1];
                                break;
                            case '-':
                                number[numCount - 2] -= number[numCount - 1];
                                break;
                            case '×':
                                number[numCount - 2] *= number[numCount - 1];
                                break;
                        }
                        numCount-- ;
                        opCount--;
                    }
                    weight[opCount] = weightTemp;
                    operator[opCount] = ch;
                    opCount++ ;
                }
            }
        }

        while(opCount > 0){
            switch (operator[opCount - 1]){
                case '+':
                    number[numCount - 2] += number[numCount - 1];
                    break;
                case '-':
                    number[numCount - 2] -= number[numCount - 1];
                    break;
                case '×':
                    number[numCount - 2] *= number[numCount - 1];
                    break;
            }
            numCount--;
            opCount--;
        }
        return number[0];
    }


}
