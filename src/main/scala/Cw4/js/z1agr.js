printjson(
db.people.aggregate([
{$group:{
	_id:"$sex",avgHeight:{$avg:{$toDecimal:"$height"}},
	avgWeight:{$avg:{$toDecimal:"$weight"}}
}},
{$project:{
	avgHeightR: {$round: ['$avgHeight',2]},
	avgWeightR: {$round: ['$avgWeight',2]}} }
]).toArray())