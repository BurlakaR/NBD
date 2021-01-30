db.people.mapReduce( 
function(){ 
emit(this.sex,{weight:this.weight,height:this.height, count:1});
}, 
function(key,values){
rval = {averageWeight:0,averageHeight:0, count:0};
for(var i =0;i<values.length;i++)
{
	rval.averageWeight += parseFloat(values[i].weight);
	rval.averageHeight += parseFloat(values[i].height);
	rval.count += values[i].count;
}
return rval;
}, 
{ 
out:"average_measures",
finalize: function(key,rval){
	rvalEnd = {
		averageHeight:(rval.averageHeight/rval.count).toFixed(2) ,
		averageWeight:(rval.averageWeight/rval.count).toFixed(2) 
	}
	return rvalEnd;	
} 
})
printjson(db.average_measures.find().toArray())