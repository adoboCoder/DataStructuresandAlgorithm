class Joke():
    favs = [] #class

    def __init__(self, id, joke):
        self.id = id
        self.joke = joke
    

    def is_short(self):
        if(len(self.joke) > 50):
            return False

    def __str__(self):
        return f"Joke ID: {self.id}, the joke is {len(self.joke)}  characters long"


    __hash__ = None


    def __repr__(self): #added to make list of items invoke str
        return self.__str__()