import riak

client = riak.RiakClient()
dndClasses = [ {'class': 'Fighter', 'hit die': 10, 'Primary Ability': 'Strength', 'Saves': 'Strength+Constitution'}, 
                                  {'class': 'Cleric', 'hit die': 8, 'Primary Ability': 'Wisdom ', 'Saves': 'Wisdom+Charisma'},
                                  {'class': 'Rogue', 'hit die': 8, 'Primary Ability': 'Dexterity ', 'Saves': 'Dexterity+Intelligence'},
				  {'class': 'Wizard', 'hit die': 6, 'Primary Ability': 'Intelligence', 'Saves': 'Intelligence+Wisdom'}]

bucket = client.bucket('classes')
keys = []

for dndClass in dndClasses:
        keys.append(dndClass['class'])
        classriak = bucket.new(dndClass['class'], data = dndClass)
        classriak.store()
print("All documents have been added.")
 

riakStoredClasses=[bucket.get(k) for k in keys]
print("Riak: ")
print([dndClass.data for dndClass in riakStoredClasses])
 
toChange = bucket.get("Fighter")
toChange.data['Primary Ability'] = 'Dexterity'
toChange.store()

print("Updated Fighter : ")
print(bucket.get('Fighter').data)
           
for dndClass in riakStoredClasses:
	dndClass.delete()
print("Deleted document reading: ")
for dndClass in riakStoredClasses:
        print(dndClass.data)