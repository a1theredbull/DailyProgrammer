using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace NCharacterSetStrings
{
    public class UniqueCharScanner
    {
        public string[] lines;

        public UniqueCharScanner(string[] lines, int target)
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
            System.Console.WriteLine("Enter target # of distinct characters: ");
            int target = 0;
            try
            {
                target = Int32.parse(Console.ReadLine());
            }
            catch (FormatException e)
            {
                System.Console.WriteLine("Bad target.");
                return;
            }
            System.Console.WriteLine("Enter file: ");
            string filename = Console.ReadLine();
            string[] lines = System.IO.File.ReadAllLines(filename);
            UniqueCharScanner ucs = new UniqueCharScanner(lines, target);
        }
    }
}
