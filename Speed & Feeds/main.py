import math

tool = {
    "Magnesium": 300,
    "Aluminum": 250,
    "Brass": 150,
    "Bronze": 150,
    "Copper": 100,
    "Cast Iron (Soft)": 80,
    "Cast Iron (Hard)": 50,
    "Mild Steel": 90,
    "Cast Steel": 80,
    "Alloy Steel (Hard)": 40,
    "Tool Steel": 50,
    "Stainless Steel": 60,
    "Titanium": 50,
    "High Manganese Steel": 30
}

materialFace = {
    "Magnesium": 0.005,
    "Aluminum": 0.005,
    "Brass": 0.004,
    "Bronze": 0.004,
    "Copper": 0.004,
    "Cast Iron (Soft)": 0.004,
    "Cast Iron (Hard)": 0.004,
    "Mild Steel": 0.004,
    "Cast Steel": 0.004,
    "Alloy Steel (Hard)": 0.004,
    "Tool Steel": 0.004,
    "Stainless Steel": 0.004,
    "Titanium": 0.004,
    "High Manganese Steel": 0.004
}

materialSide = {
    "Magnesium": 0.004,
    "Aluminum": 0.004,
    "Brass": 0.004,
    "Bronze": 0.004,
    "Copper": 0.004,
    "Cast Iron (Soft)": 0.004,
    "Cast Iron (Hard)": 0.002,
    "Mild Steel": 0.002,
    "Cast Steel": 0.002,
    "Alloy Steel (Hard)": 0.002,
    "Tool Steel": 0.002,
    "Stainless Steel": 0.002,
    "Titanium": 0.002,
    "High Manganese Steel": 0.002
}

materialEnd = {
    "Magnesium": 0.005,
    "Aluminum": 0.005,
    "Brass": 0.005,
    "Bronze": 0.005,
    "Copper": 0.004,
    "Cast Iron (Soft)": 0.004,
    "Cast Iron (Hard)": 0.002,
    "Mild Steel": 0.002,
    "Cast Steel": 0.002,
    "Alloy Steel (Hard)": 0.002,
    "Tool Steel": 0.002,
    "Stainless Steel": 0.002,
    "Titanium": 0.002,
    "High Manganese Steel": 0.002
}
def Calculate():
    print("""
    1. Magnesium
    2. Aluminum
    3. Brass
    4. Bronze
    5. Copper
    6. Cast Iron (Soft)
    7. Cast Iron (Hard)
    8. Mild Steel
    9. Cast Steel
    10. Alloy Steel (Hard)
    11. Tool Steel
    12. Stainless Steel
    13. Titanium
    14. High Manganese Steel
    """)
    material = input("Select Material (1-14): ")
    if material == "1":
        material = "Magnesium"
    elif material == "2":
        material = "Aluminum"
    elif material == "3":
        material = "Brass"
    elif material == "4":
        material = "Bronze"
    elif material == "5":
        material = "Copper"
    elif material == "6":
        material = "Cast Iron (Soft)"
    elif material == "7":
        material = "Cast Iron (Hard)"
    elif material == "8":
        material = "Mild Steel"
    elif material == "9":
        material = "Cast Steel"
    elif material == "10":
        material = "Alloy Steel (Hard)"
    elif material == "11":
        material = "Tool Steel"
    elif material == "12":
        material = "Stainless Steel"
    elif material == "13":
        material = "Titanium"
    elif material == "14":
        material = "High Manganese Steel"
    print("""
    1. Face
    2. Side
    3. End
    Choose End if coutntersinking, counterboring, or plunging
        """)
    operation = input("Select Operation (1-3): ")
    diameter = float(input("Diameterc (in): "))
    teeth = float(input("Teeth: "))
    spindle = tool[material] * 12 / diameter / math.pi
    if input("Is Carbide? (y/n): ") == "y":
        spindle *= 2
    if input("Is Countersinking? (y/n): ") == "y":
        feed = spindle * 0.25
    if input("Is Counterboring? (y/n): ") == "y":
        feed = spindle * 0.25
    if input("Is Plunging? (y/n): ") == "y":
        feed = spindle * 0.5
    if operation == "1":
        feed *= materialFace[material] * teeth
    elif operation == "2":
        feed *= materialSide[material] * teeth
    elif operation == "3":
        feed *= materialEnd[material] * teeth
    
    print(spindle)
    print(feed)

Calculate()