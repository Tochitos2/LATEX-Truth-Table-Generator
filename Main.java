package com.company;

import java.util.Scanner;

public class Main {

    //TODO: Replace string additions with StringBuilders.
    public static void main(String[] args) {

        // Get the number of variables.
        Scanner scanner = new Scanner(System.in);
        int argument = scanner.nextInt();
        int variables = argument;
        int rows = (int)Math.pow(2, variables);
        String value = "T";
        int setLength =  1;
        int currentLength;
        String[][] values = new String[rows][variables];
        String line;

        // Generate table data.
        for(int i = 0; i < variables; i++)
        {
            currentLength = 0;

            for(int j =0; j < rows; j++)
            {
                values[j][i] = value;
                currentLength++;

                if(currentLength == setLength)
                {
                    if(value == "T") { value = "F"; }
                    else { value = "T"; }
                    currentLength = 0;
                }
            }
            // Pattern doubles each column.
            setLength *= 2;
        }

        // Output table declaration.
        String columnDeclaration = "|";
        for(int i = 0; i <= variables; i++) columnDeclaration += "c|";
        String tableStart = "\\begin{table}\n" + "\\centering\n" + "\\begin{tabular}" + "{" + columnDeclaration + "}" + "\n\\hline";
        System.out.println(tableStart);

        // Output column template.
        String columns = "";
        char variable = 'A';
        for(int i = 0; i < variables; i++)
        {
            columns += variable + " & ";
            variable++;
        }
        columns += "\\\\\n\\hline";
        System.out.println(columns);


        //output data rows
        for(int i = 0; i < rows; i++)
        {
            line = "";

            for(int j = variables-1; j >= 0; j--)
            {
                line += values[i][j];
                if(j != 0)
                {
                    line += " & ";
                }
            }
            line += "\\\\ \\hline";
            System.out.println(line);
        }

        // Output end of table.
        String tableEnd = "\\end{tabular}\n" + " \\end{table}";
        System.out.println(tableEnd);
    }
}
