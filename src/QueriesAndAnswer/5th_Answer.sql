--Query to calculate the total distance for each route

SELECT rp.route_id,r.name,SUM(rp.distance) AS total_distance
FROM routes r INNER JOIN route_points rp ON r.id = rp.route_id
GROUP BY rp.route_id, r.name ORDER BY rp.route_id desc;