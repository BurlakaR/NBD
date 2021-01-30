printjson(db.people.aggregate([
{
	$match:{sex:"Female",nationality:"Poland"}
},
{
	$unwind: "$credit" 
},
{
	$group:{_id:"$credit.currency",averageFunds: {$avg:{$toDecimal:"$credit.balance"}},funds:{$sum:{$toDecimal:"$credit.balance"}}}},
	{
		$project:{averageFunds: {$round: ['$averageFunds',2]},totalFunds: '$funds'}
	}
]).toArray())