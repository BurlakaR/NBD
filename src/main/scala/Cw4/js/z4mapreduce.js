db.people.mapReduce( 
function(){ 
	bmi = parseFloat(this.weight)/Math.pow(parseFloat(this.height/100),2)
	emit(this.nationality,{maxBMI:bmi,minBMI:bmi,sumBMI:bmi, count:1});
}, 
function(key,values){
	rval = {maxBMI:values[0].maxBMI,minBMI:values[0].minBMI,avgBMI:0, count:0}
	for (i = 0;i<values.length;i++){
		rval.avgBMI += values[i].sumBMI;
		rval.count += values[i].count;
		if(values[i].maxBMI > rval.maxBMI){
			rval.maxBMI = values[i].maxBMI;
		}
		if(values[i].minBMI < rval.minBMI){
			rval.minBMI = values[i].minBMI;
		}
	}
	return rval;
}, 
{ 
out:"BMI_data" ,
finalize: function(key, rVal){
	return {
		maxBMI:(rVal.maxBMI).toFixed(2),minBMI:(rVal.minBMI).toFixed(2),
		averageBMI:(rVal.avgBMI/rVal.count).toFixed(2)
	}
}})
printjson(db.BMI_data.find().toArray())