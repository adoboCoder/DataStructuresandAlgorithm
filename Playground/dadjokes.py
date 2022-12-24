import requests
import json
import pprint

url = "https://dad-jokes.p.rapidapi.com/random/joke"

headers = {
	"X-RapidAPI-Key": "7d4f0752d3msh96b92a6c2bfee0dp1d0a3ajsndf847fa3c225",
	"X-RapidAPI-Host": "dad-jokes.p.rapidapi.com"
}

response = requests.request("GET", url, headers=headers)
response = response.json()
print(response['body'][0]['setup'])
print(response['body'][0]['punchline'])

