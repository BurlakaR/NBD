printjson(db.people.aggregate([
{
	$group:{
		_id:"$nationality",
		maxBMI:{$max:{$divide:[{$multiply:[{$toDecimal:"$weight"},10000]},{$multiply:[{$toDecimal:"$height"},{$toDecimal:"$height"}]}]}},
		minBMI:{$min:{$divide:[{$multiply:[{$toDecimal:"$weight"},10000]},{$multiply:[{$toDecimal:"$height"},{$toDecimal:"$height"}]}]}},	
		avgBMI:{$avg:{$divide:[{$multiply:[{$toDecimal:"$weight"},10000]},{$multiply:[{$toDecimal:"$height"},{$toDecimal:"$height"}]}]}}
}},
{
	$project:{avgBMI_: {$round: ['$avgBMI',2]},maxBMI_: {$round: ['$maxBMI',2]},minBMI_:{$round: ['$minBMI',2]}} 
}
]).toArray())