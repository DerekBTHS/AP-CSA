from Scoreboard import Scoreboard

# fetch text file
filePath = "/Users/Derek/Desktop/BTHS Repos/AP CSA/Scoreboard/Scoreboard.txt"
file = open(f"{filePath}", mode="r")
lines = file.readlines()
file.close()

wins = {}
ties = 0

# simulate each game in text file
for line in lines:
    team1 = line.split(" ")[0]
    team2 = line.split(" ")[1]
    inputs = list(line.split(" ")[2:-1])
    game = Scoreboard(team1, team2, inputs)
    if game.winner() in wins and game.winner():
        wins.update({game.winner() : wins.get(game.winner()) + 1})
    else:
        wins.update({game.winner() : 1})

# check whether games simulated is equal to lines in text file
totalGames = 0
for key in wins:
    totalGames += wins[key]
print(f"{totalGames} games simulated")
del wins["tie"]

# sort dictionary in descending order
wins = dict(sorted(wins.items(), key=lambda item: item[1], reverse=True))
for team in wins:
    print(f"{team} : {wins[team]}")