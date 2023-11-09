import math

class User:
    def __init__(self, user_type):
        self.user_type = user_type

def calculate_shipping_price(origin, destination, package_weight, is_fragile, user):
    distance = calculate_distance_between_coordinates(origin, destination)
    cost = calculate_shipping_cost(distance, package_weight, is_fragile)
    cost = apply_discount(cost, user)
    return cost

def haversine_distance(lat1, lon1, lat2, lon2):
    delta_lat = lat2 - lat1
    delta_lon = lon2 - lon1
    a = math.sin(delta_lat / 2) ** 2 + math.cos(lat1) * math.cos(lat2) * math.sin(delta_lon / 2) ** 2
    c = 2 * math.atan2(math.sqrt(a), math.sqrt(1 - a))
    earth_radius = 6371.0
    distance = earth_radius * c
    return distance

def calculate_distance_between_coordinates(point1, point2):
    lat1, lon1, lat2, lon2 = map(math.radians, [point1[0], point1[1], point2[0], point2[1]])
    return haversine_distance(lat1, lon1, lat2, lon2)

def calculate_shipping_cost(distance, package_weight, is_fragile):
    if package_weight <= 5:
        cost = distance * 10
    else:
        cost = distance * 10 + (package_weight - 5) * 2

    if is_fragile:
        cost = cost * 1.5

    return cost

def apply_discount(cost, user):
    if user.user_type == 'gold':
        cost = cost * 0.8
    elif user.user_type == 'silver':
        cost = cost * 0.9
    return cost

def main():
    user = User('gold')
    origin = (4.602, -74.065)
    destination = (40.748, -73.986)
    package_weight = 30
    is_fragile = True
    shipping_price = calculate_shipping_price(origin, destination, package_weight, is_fragile, user)
    print(shipping_price)

if __name__ == "__main__":
    main()

