#include <pthread.h> 
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <string.h>
#include <signal.h>

void* find_file(void* arg);
void print_stats(int signNum);

int request_count = 0;
int total_wait = 0;
int index = 0;

typedef struct
{
   char* name;
   int thread;
} file;

file* info;

int
main(int argc, char* argv[])
{
   printf("\n========= File Server Simulation =========\n\n");
   char* input;
   input = malloc(24 * sizeof(char));
   int status;

   info = (file*)malloc(10 * sizeof(file));

   srand(time(NULL));
   signal(SIGINT, print_stats);

   while(1)
   {
       pthread_t thread;
       printf("Find: ");
       fgets(input, sizeof input, stdin);
       input[strlen(input) - 1] = '\0';

       file temp;
       //requires buffer to copy input to name
       char* buffer = malloc(24 * sizeof(char));
       strcpy(buffer, input);
       temp.name = buffer;
       temp.thread = index;
       info[index] = temp;
       index++;

       if ((status = pthread_create(&thread, NULL, find_file, info)) != 0)
       {
           perror("ERR: Thread spawn failed.");
           exit(1);
       }
   }

   free(input);
   free(info);
}

void*
find_file(void* arg)
{
    file* info = (file*)arg;
    file buffer;

    for(int i = 0; i < index; i++)
    {
        if(info[i].thread == request_count)
        {
            buffer = info[i];
            break;
        }
    }

    request_count++;

    int prob = rand() % 5;

    if(!prob)
    {
        int sec = (rand() % 4) + 7;
        sleep(sec);
        printf("\nCould not find file '%s'\n", buffer.name);
        total_wait += sec;
    }
    else
    {
        sleep(1);
        printf("\nFound file '%s'\n", buffer.name);
        total_wait++;
    }

    return arg;
}

void
print_stats(int sigNum)
{
    printf("\nNumber of file requests: %d\n", request_count);
    printf("Average file access time: %f\n", (double)total_wait / (double)request_count);
    printf("Exiting...\n");
    exit(0);
}
