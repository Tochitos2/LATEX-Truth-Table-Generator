package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Get the number of variables.
        Scanner scanner = new Scanner(System.in);
        int variables = scanner.nextInt();
        int rows = (int)Math.pow(2, variables);
        String value = "T";
        int setLength =  1;
        int currentLength;
        String[][] values = new String[rows][variables];
        StringBuilder line;

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
                    if(value.equals("T") ) value = "F";
                    else { value = "T"; }
                    currentLength = 0;
                }
            }
            // Pattern doubles each column.
            setLength *= 2;
        }

        // Output table declaration.
        StringBuilder columnDeclaration = new StringBuilder("|");
        for(int i = 0; i <= variables; i++) columnDeclaration.append("c|");
        String tableStart = "\\begin{table}[!htb]\n" + "\\centering\n" + "\\begin{tabular}" + "{" + columnDeclaration + "}" + "\n\\hline";
        System.out.println(tableStart);

        // Output column template.
        StringBuilder columns = new StringBuilder();
        char variable = 'A';
        for(int i = 0; i < variables; i++)
        {
            columns.append(variable).append(" & ");
            variable++;
        }
        columns.append("\\\\\n\\hline");
        System.out.println(columns);


        //output data rows
        for(int i = 0; i < rows; i++)
        {
            line = new StringBuilder();

            for(int j = variables-1; j >= 0; j--)
            {
                line.append(values[i][j]);
                if(j != 0)
                {
                    line.append(" & ");
                }
            }
            line.append("\\\\ \\hline");
            System.out.println(line);
        }

        // Output end of table.
        String tableEnd = "\\end{tabular}\n" + " \\end{table}";
        System.out.println(tableEnd);
    }
}
