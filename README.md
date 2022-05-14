# Offline Coding Task – Sponsored Search Auctions
Highest bidder wins the auction

## Preliminaries and rules:
  + Today’s task is given by this text. By purpose, it is very large and almost impossible to implement to the
  fullest extend within given time. It is up to you to define the scope! Please focus on the most important
  functionality first
  + Please read the following introduction and requirements text first, so you know all requirements and
    design your software up front to prevent major changes during the coding process. It is up to you to decide ‐
    on the scope of the task if you think you cannot implement all requirements, please focus on the ‐
    important ones and decide which will not be implemented!
  + Proceed in an incremental, way to solve the task. Ensure that at any point in time, your solution can be
    executed and add small features one by one. In this way, the time limit will not hinder you to deliver at
    least a partial solution – which is very acceptable.
  + The maximum allowed time for completing this task is 3 hours, which includes reading this description.

## Definition of done:
  + Unit and integration tests are given that demonstrate the correctness of your code. 
  + The code adheres to high quality standards (as few lines of code as possible), best practices and a
clear structure. The code is easy to read without requiring comments and uses object oriented
features such as inheritance and design patterns to make the code extensible and easy to maintain.
  + The resulting software is functional and can be tested by us.

## Introduction:

 + Sponsored search is a type of web search engine advertising. Typically advertisers try to place their web
site offerings in a special region above the regular, algorithmic web search result list. The positions in this
special, sponsored result region are sold in auctions, where advertisers place bids for search terms. The
highest bid wins and is displayed as the top most sponsored search result. For example, when a user
queries a web search engine for “stock trading”, advertisers such as online banks may bid to have their
listings featured alongside the regular, algorithmic search result listings.
 + The advertisements appear in a separate section of the page designated as “sponsored” results. The
sponsored search results are displayed in a format similar to algorithmic search results: as a list of items
each containing a title, a text description, and a hyperlink to a corresponding web page. We call each
position in the list a slot.
 + Generally, advertisements that appear in a higher ranked slot (higher on the page) gain more attention andmore clicks from users. Thus, advertisers generally prefer higher ranked slots to lower ranked slots.
Advertisers bid for placement on the page in an auction style format where the higher their bid’s value, the ‐
more likely their listing will appear above other advertisements on the result page.
 + By convention, sponsored search advertisers pay per click, meaning that they pay only when a user clicks
on their offering, and do not pay if their advertisement is displayed but not clicked. Google is the most
prominent web search engine that employs this business model.
 + The sponsored search industry typically runs separate auctions for different search queries: for example,
the queries “plasma television” and “investment advice” are associated with two distinct auctions.
As mentioned, bids are expressed as a maximum willingness to pay per click. For example, a 50‐cent bid
by CHECK24 for “accident insurance” means CHECK24 is willing to pay up to 50 cents every time a user
clicks on their advertisement.
 + In practice, hundreds of thousands of advertisers compete for positions alongside several millions of
search queries every day.
 + Generally the auctions are continuous and dynamic, meaning that advertisers can change their bids at any
time. Each time a user searches for a search term, the auction uses the current bids. In this way, advertisers
can adapt to changing environments, for instance by boosting their bids for the query “flowers” during the
week before Valentine’s Day. The auctioneer, in this case the search engine, evaluates the bids and
allocates slots to advertisers.
 + Every time a user searches for a keyword, an auction takes place among the set of interested advertisers
who have not exhausted their budgets.
 + The search engine assigns a weight wj to each bidder j. If agent j bids bj, his corresponding score is sj =
wjbj. The search engine allocates slots in decreasing order of scores, so that the agent with highest score is
ranked first, and so on. We assume throughout that agents are numbered so that agent j obtains slot j.
 + The following two bid ranking mechanism have been often used in practice: the “rank by bid” mechanism
(wj = 1) and the “rank by score” mechanism (wj = α1j). Similarly there are two prominent mechanisms
how much a bidder pays: the“generalized first price auction” when the bidder who secures a slot pays
their bid amount per click and the “generalized second price auctions” when the bidder pays per click the
lowest bid necessary to retain his position, so that the bidder in slot j pays sj+1/w

## Requirements and Task:
+ Implement a simple, sponsored search auction system that implements all four described auction
mechanisms ‐ two bid ranking mechanisms and two pricing mechanisms.
+ Before any auction is executed, the auctioneer defines which ranking and pricing mechanism shall beapplied. The auctioneer also determines weights wj for each bidder if these values are required. A bidder
holds a private set of bids that are registered in the auction system. Each such bid is associated with a
search term, a maximum bid price and a budget that only the bidder knows of. The bidder may change the
maximum bid price and budget over time.
+ The auction is evaluated once a user searches for a search term for which at least one bidder has registered
at the auction system. The bidder is only charged if the user clicks on a slot in the sponsored result
containing an advertisement of the bidder. The user does not need to click on any slot. The auction system
makes sure that the budget of bidder is not overrun. In an auction, bidders are competing for a fixed
number of slots in sponsored search results. A bidder may only win a single slot in any auction.
+ Please provide unit and integration tests to drive your software; we do not require any user interface or ‐
RESTful API! Focus on the domain model and the verification of the provided functionality.
