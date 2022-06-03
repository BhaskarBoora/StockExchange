# StockExchange


Stock Exchange is a basic code setup to enable buy and sell of different stocks.

INPUT:
#1 09:45 BAC sell 240.12 100
#2 09:46 BAC sell 237.45 90
#3 09:47 BAC buy 238.10 110
#4 09:48 BAC buy 237.80 10
#5 09:49 BAC buy 237.80 40
#6 09:50 BAC sell 236.00 50

OUTPUT:
#3 237.45 90 #2
#3 236.00 20 #6
#4 236.00 10 #6
#5 236.00 20 #6


Driver.java -> The executor class to run the codebase, it accepts the file path from which input is to be read.
BusinessService -> basically contains the code to take decision on what gets bought and sold (if any).
StockExchange controller -> The api is basically exposed here and it internally calls the business service.
