--Query to get result for same route by stop id for source and destination:


SELECT r.id AS route_id,rp1.stop_id AS source_stop_id,rp2.stop_id AS dest_stop_id
FROM routes r JOIN route_points rp1 ON r.id = rp1.station_id
JOIN route_points rp2 ON r.id = rp2.station_id
WHERE rp1.order = 1 AND rp2.order = (SELECT MAX(order) FROM route_points WHERE station_id = r.id);


--Optional Answer


SELECT r.id AS route_id,s1.station_name AS source_stop_name,s2.station_name AS dest_stop_name
FROM routes r JOIN route_points rp1 ON r.id = rp1.station_id JOIN route_points rp2 ON r.id = rp2.station_id
JOIN station s1 ON rp1.stop_id = s1.id JOIN station s2 ON rp2.stop_id = s2.id
WHERE rp1.order1 = 1 AND rp2.order1 = (SELECT MAX(order1) FROM route_points WHERE station_id = r.id);