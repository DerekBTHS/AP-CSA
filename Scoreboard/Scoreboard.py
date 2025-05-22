class Scoreboard:
    # construct class so that args contains all inputs after the team names
    def __init__ (self, team1, team2, *args):
        self.team1 = team1
        self.team2 = team2
        self.args = args

    def winner(self):
        score1 = 0
        score2 = 0
        teamScoring = 1
        # for each input check if team in play is swapped and add score
        for arg in self.args[0]:
            if teamScoring == 1:
                if int(arg) == 0:
                    teamScoring = 2
                else:
                    score1 += int(arg)
            else:
                if int(arg) == 0:
                    teamScoring = 1
                else:
                    score2 += int(arg)
        # return team with most points or whether game is a tie
        if score1 > score2:
            return self.team1
        elif score2 > score1:
            return self.team2
        elif score1 == score2:
            return "tie"