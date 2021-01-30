db.people.mapReduce( 
function(){ 
for(var i=0;i<this.credit.length;i++){
	var key = this.credit[i].currency;
	var value = {funds:this.credit[i].balance};
	emit(key,value);
}
}, 
function(key,values){
	rval = 0;
	for (var i = 0;i< values.length;i++){
	rval += parseFloat(values[i].funds);	
	}
	return rval;
}, 
{ out:"funds_in_each_currency" } )
printjson(db.funds_in_each_currency.find().toArray())