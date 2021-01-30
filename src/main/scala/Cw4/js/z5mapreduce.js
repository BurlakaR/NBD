db.people.mapReduce( 
function(){ 
for(var i=0;i<this.credit.length;i++){
	var key = this.credit[i].currency;
	var value = {total:this.credit[i].balance, count:1};
	emit(key,value);
}}, 
function(key,values){
	rVal = {count:0,total:0};
	for (var i = 0;i< values.length;i++){
		rVal.total += parseFloat(values[i].total);
		rVal.count += values[i].count;
	}
	return rVal;
}, 
{ 
	query:{sex:"Female",nationality:"Poland"},
	out:"funds_per_currency_for_poland",
	finalize: function(key,redVal){
		return {averageFunds: (redVal.total/redVal.count).toFixed(2), totalFunds: redVal.total}
}})
printjson(db.funds_per_currency_for_poland.find().toArray())