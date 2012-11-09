using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace NCharacterSetStrings
{
    public class UniqueCharScanner
    {
        public string[] lines;
        public UniqueCharScanner(string[] lines)
        {
            this.lines = lines;

            int count = 0;
            foreach (string line in lines)
                if(ncset(line, 4)) count++;
            System.Console.WriteLine(count);
            System.Console.ReadLine();
        }

        //challenge was actually just to write this function, so I kept it as a function
        private bool ncset(string s, int n)
        {
            return s.ToCharArray().Distinct<char>().Count<char>() <= n;
        }

        public static void Main()
        {
            System.Console.WriteLine("I will take a list of words.  I will find out how many of those words" +
                " are composed of a number of unique letters less than 4");
            System.Console.WriteLine("Enter file: ");
            string filename = Console.ReadLine();
            string[] lines = System.IO.File.ReadAllLines(filename);
            UniqueCharScanner ucs = new UniqueCharScanner(lines);
        }
    }
}
