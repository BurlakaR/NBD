printjson(
db.people.aggregate([
	{$unwind: "$credit" },
	{$group:{
		_id:"$credit.currency",
		funds:{
			$sum:{
				$toDecimal:"$credit.balance"
}}}}]).toArray())