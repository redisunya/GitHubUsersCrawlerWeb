# GitHubUsersCrawlerWeb
It is a mini web crawler which uses GitHub API to get some information about an user and user's repositories 
and display this information on a web-page. 

Initially this project is planned to be developed with this structure:
<ul>
<li>Core - will be almost the same as it's written in <b>MiniWebCrawler</b> project.</li>
<li>HTTP Server - I will try to use <b>Jetty</b> as a ready to go HTTP-server and adjust it according my needs.</li>
<li>Web pages - There also will be some pages to be able to log in, register, and for the main functionality. I will try 
to user <b>freemarker</b> to generate pages.</li>
<li>Data Base - I also plan to use data base to store some data in there, as far as I use Postgres at work, my database also will be <b>Postgres</b></li>
</ul>

The main scenario.

A person opens initial page, where the person can log in, or create an account. After logging in, the person
is redirected on the main page where he or she can enter a GitHub user's login and sends a request to the server side.
Server side recieves the request and uses the entered login to create a request to GitHub API, after receiving a GitHub API response 
the server side searches it though to get some data, like repositories, popularity, languages, so on. 
Than server side sends a response to the browser and the user can see web page with data.

GitHUb API - https://developer.github.com/v3/


