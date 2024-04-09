# MultiThreadedWebServer
## Points:
- 1: Pulling lots of Requests
- 2: Pulled 6k requests from client in SingleThreaded almost smoothly.
- 3 : Pulled 60k requests from Client in MultiThreaded almost smoothly.
- 4 : Pulled 600k requests from client in ThreadPool almost smoothly . 
thus indicating the efficiency difference .
- 5 : Done with jmeter.

# How to run 
## Steps
1. **Clone the repository:**
 ```bash
    https://github.com/aritrakar95/MultiThreadedWebServer
````
2. Set up Jmeter 
3. Inside Jmeter
  - a. Create a test run
  - b.Create a thread group
  - c.Inside it create TCP Sampler
  - d. Select view results in Table , tree , graph
4.Finally run steps
 - Open terminal and select the server you want to run
 - Afer server port is listening start the file in jmeter
 - now the results will get displayed in jmeter.
