db.people.mapReduce( 
function(){
	emit("professions_list", [this.job]);
}, 
function(key,values){
	var uniquelist = [];
	for(var i = 0; i < values.length; i++){
		uniquelist = uniquelist.concat(values[i]);
	}
	uniquelist = [...new Set(uniquelist)]
	return uniquelist;	
}, 
{ out:"list_unique_professions" } )
printjson(db.list_unique_professions.find().toArray())