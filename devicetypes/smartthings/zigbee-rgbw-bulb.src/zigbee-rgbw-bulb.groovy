/**
 *  Copyright 2017 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  Author: SmartThings
 *  Date: 2016-01-19
 *
 *  This DTH should serve as the generic DTH to handle RGBW ZigBee HA devices
 */
import physicalgraph.zigbee.zcl.DataType

metadata {
	definition (name: "ZigBee RGBW Bulb", namespace: "smartthings", author: "SmartThings", runLocally: true, minHubCoreVersion: '000.019.00012', executeCommandsLocally: true, genericHandler: "Zigbee") {

		capability "Actuator"
		capability "Color Control"
		capability "Color Temperature"
		capability "Configuration"
		capability "Refresh"
		capability "Switch"
		capability "Switch Level"
		capability "Health Check"
		capability "Light"

		attribute "colorName", "string"

		// Generic fingerprint
		fingerprint profileId: "0104", deviceId: "0102", inClusters: "0006, 0008, 0300", deviceJoinName: "Light" //Generic RGBW Light
		fingerprint profileId: "0104", deviceId: "010D", inClusters: "0006, 0008, 0300", deviceJoinName: "Light" //Generic RGBW Light
		
		// Samsung LED
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300", outClusters: "0019", manufacturer: "Samsung Electronics", model: "SAMSUNG-ITM-Z-002", deviceJoinName: "Samsung Light", mnmn: "Samsung Electronics", vid: "SAMSUNG-ITM-Z-002" //ITM RGBW
		
		// ABL
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300", outClusters: "0019", manufacturer: "Juno", model: "ABL-LIGHT-Z-201", deviceJoinName: "Juno Connect", mnmn: "SmartThingsCommunity", vid: "0c0d8ed8-d536-324c-9b80-d4705a55e4df"	//E-series
		
		// AduroSmart
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 1000", outClusters: "0019", deviceId: "010D", manufacturer: "AduroSmart Eria", model: "AD-RGBW3001", deviceJoinName: "Eria Light" //Eria ZigBee RGBW Bulb

		// Aurora/AOne
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300", outClusters: "0019", manufacturer: "Aurora", model: "RGBCXStrip50AU", deviceJoinName: "AOne Light", mnmn:"SmartThings", ocfDeviceType: "oic.d.switch", vid: "generic-rgbw-color-bulb-2500K-6000K" //AOne Smart Strip Controller
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000, FEDC", outClusters: "000A, 0019", manufacturer: "Aurora", model: " RGBGU10Bulb50AU", deviceJoinName: "Aurora Light" //Aurora Smart RGBW
		fingerprint profileId: "0104", inClusters: "0000, 0004, 0003, 0006, 0008, 0005, 0300, FFFF, 1000", outClusters: "0019", manufacturer: "Aurora", model: "RGBBulb51AU", deviceJoinName: "Aurora Light" //Aurora RGBW GLS Lamp
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 1000, FFFF", outClusters: "0019", manufacturer: "Aurora", model: "RGBBulb51AU", deviceJoinName: "AOne Light" //AOne Smart RGBW GLS Lamp
        
		//CWD 
		// raw description "01 0104 010D 01 0A 0000 0003 0004 0005 0006 0008 0300 0B05 1000 FC82 02 000A 0019"
		fingerprint manufacturer: "CWD", model: "ZB.A806Ergbw-A001", deviceJoinName: "CWD Light" //model: "E27 RGBW & Colour Tuneable", brand: "Collingwood"
		// raw description "01 0104 010D 01 0A 0000 0003 0004 0005 0006 0008 0300 0B05 1000 FC82 02 000A 0019"
		fingerprint manufacturer: "CWD", model: "ZB.A806Brgbw-A001", deviceJoinName: "CWD Light" //model: "BC RGBW & Colour Tuneable", brand: "Collingwood"
		// raw description "01 0104 010D 01 0A 0000 0003 0004 0005 0006 0008 0300 0B05 1000 FC82 02 000A 0019"
		fingerprint manufacturer: "CWD", model: "ZB.M350rgbw-A001", deviceJoinName: "CWD Light" //model: "GU10 RGBW & Colour Tuneable", brand: "Collingwood"
        
		// Innr
		fingerprint profileId: "0104", inClusters: "0000, 0004, 0003, 0005, 0006, 0008, 0300, 1000", outClusters: "0019", manufacturer: "innr", model: "RB 285 C", deviceJoinName: "Innr Light", mnmn: "SmartThings", vid: "generic-rgbw-color-bulb-1800K-6500K" //Innr Smart Bulb Color
		fingerprint profileId: "0104", inClusters: "0000, 0004, 0003, 0005, 0006, 0008, 0300, 1000", outClusters: "0019", manufacturer: "innr", model: "BY 285 C", deviceJoinName: "Innr Light", mnmn: "SmartThings", vid: "generic-rgbw-color-bulb-1800K-6500K" //Innr Smart Bulb Color
		fingerprint manufacturer: "innr", model: "RB 250 C", deviceJoinName: "Innr Light", mnmn: "SmartThings", vid: "generic-rgbw-color-bulb-1800K-6500K" //Innr Smart Candle Colour
		fingerprint manufacturer: "innr", model: "RS 230 C", deviceJoinName: "Innr Light", mnmn: "SmartThings", vid: "generic-rgbw-color-bulb-1800K-6500K" //Innr Smart GU10 Spot Colour
		fingerprint manufacturer: "innr", model: "AE 280 C", deviceJoinName: "Innr Light", mnmn: "SmartThings", vid: "generic-rgbw-color-bulb-1800K-6500K" //Innr Smart Color Bulb E26 AE 280 C

		// Müller Licht
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000, FEDC", outClusters: "000A, 0019", manufacturer: "MLI", model: "ZBT-ExtendedColor", deviceJoinName: "Tint Light", mnmn:"SmartThings", vid: "generic-rgbw-color-bulb-1800K-6500K" //Müller Licht Bulb White+Color

		// LEDVANCE/OSRAM/SYLVANIA
		fingerprint profileId: "0104", inClusters: "0000,0003,0004,0005,0006,0008,0300,0B04,FC0F", outClusters: "0019", manufacturer: "OSRAM", model: "LIGHTIFY Flex RGBW", deviceJoinName: "SYLVANIA Light" //SYLVANIA Smart Flex RGBW
		fingerprint profileId: "0104", inClusters: "0000,0003,0004,0005,0006,0008,0300,0B04,FC0F", outClusters: "0019", manufacturer: "OSRAM", model: "Flex RGBW", deviceJoinName: "OSRAM Light" //OSRAM SMART+ Flex RGBW
		fingerprint profileId: "0104", inClusters: "0000,0003,0004,0005,0006,0008,0300,0B04,FC0F", outClusters: "0019", manufacturer: "OSRAM", model: "LIGHTIFY A19 RGBW", deviceJoinName: "SYLVANIA Light" //SYLVANIA Smart A19 RGBW
		fingerprint profileId: "0104", inClusters: "0000,0003,0004,0005,0006,0008,0300,0B04,FC0F", outClusters: "0019", manufacturer: "OSRAM", model: "LIGHTIFY BR RGBW", deviceJoinName: "SYLVANIA Light" //SYLVANIA Smart BR30 RGBW
		fingerprint profileId: "0104", inClusters: "0000,0003,0004,0005,0006,0008,0300,0B04,FC0F", outClusters: "0019", manufacturer: "OSRAM", model: "LIGHTIFY RT RGBW", deviceJoinName: "SYLVANIA Light" //SYLVANIA Smart RT5/6 RGBW
		fingerprint profileId: "0104", inClusters: "0000,0003,0004,0005,0006,0008,0300,0B04,FC0F", outClusters: "0019", manufacturer: "OSRAM", model: "LIGHTIFY FLEX OUTDOOR RGBW", deviceJoinName: "SYLVANIA Light" //SYLVANIA Smart RGBW Flex
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, FC01, FC08", outClusters: "0003, 0019", manufacturer: "LEDVANCE", model: "RT HO RGBW", deviceJoinName: "SYLVANIA Light" //SYLVANIA Smart RT HO RGBW
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, FC01", outClusters: "0019", manufacturer: "LEDVANCE", model: "A19 RGBW", deviceJoinName: "SYLVANIA Light" //SYLVANIA Smart A19 RGBW
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, FC01", outClusters: "0019", manufacturer: "LEDVANCE", model: "FLEX Outdoor RGBW", deviceJoinName: "SYLVANIA Light" //SYLVANIA Smart Flex RGBW
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, FC01", outClusters: "0019", manufacturer: "LEDVANCE", model: "FLEX RGBW", deviceJoinName: "SYLVANIA Light" //SYLVANIA Smart Flex RGBW
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, FC01", outClusters: "0019", manufacturer: "LEDVANCE", model: "BR30 RGBW", deviceJoinName: "SYLVANIA Light" //SYLVANIA Smart BR30 RGBW
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, FC01", outClusters: "0019", manufacturer: "LEDVANCE", model: "RT RGBW", deviceJoinName: "SYLVANIA Light" //SYLVANIA Smart RT5/6 RGBW
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, FC01", outClusters: "0019", manufacturer: "LEDVANCE", model: "Outdoor Pathway RGBW", deviceJoinName: "SYLVANIA Light" //SYLVANIA Outdoor Pathway Full Color
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, FC01", outClusters: "0019", manufacturer: "LEDVANCE", model: "Flex RGBW Pro", deviceJoinName: "SYLVANIA Light" //SYLVANIA Smart Flex 11 RGBW

		// Leedarson/Ozom
		fingerprint profileId: "0104", inClusters: "0000, 0004, 0003, 0006, 0008, 0005, 0300", outClusters: "0019", manufacturer: "LEEDARSON LIGHTING", model: "5ZB-A806ST-Q1G", deviceJoinName: "Ozom Light" //Ozom Multicolor Smart Light

		// Sengled
		fingerprint profileId: "0104", inClusters: "0000,0003,0004,0005,0006,0008,0300,0702,0B05,FC03,FC04", outClusters: "0019", manufacturer: "sengled", model: "E11-N1EA", deviceJoinName: "Sengled Multicolor"
		fingerprint profileId: "0104", inClusters: "0000,0003,0004,0005,0006,0008,0300,0702,0B05,FC03,FC04", outClusters: "0019", manufacturer: "sengled", model: "E12-N1E", deviceJoinName: "Sengled Element Color Plus"
		fingerprint profileId: "0104", inClusters: "0000,0003,0004,0005,0006,0008,0300,0702,0B05,FC03,FC04", outClusters: "0019", manufacturer: "sengled", model: "E21-N1EA", deviceJoinName: "Sengled Multicolor"
		fingerprint manufacturer: "sengled", model: "E1G-G8E", deviceJoinName: "Sengled Smart Light Strip", mnmn:"SmartThings", vid: "generic-rgbw-color-bulb-2000K-6500K"
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0702, 0B05, FC03", outClusters: "0019", manufacturer: "sengled", model: "E11-U3E", deviceJoinName: "Sengled Element Color Plus", mnmn:"SmartThings", vid: "generic-rgbw-color-bulb-2000K-6500K"
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0702, 0B05, FC03", outClusters: "0019", manufacturer: "sengled", model: "E11-U2E", deviceJoinName: "Sengled Element Color Plus"
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0702, 0B05, FC03, FC04", outClusters: "0019", manufacturer: "sengled", model: "E1F-N5E", deviceJoinName: "Sengled Light"
		
		// Q Smart Lights
		fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000, FEDC", outClusters: "000A, 0019", manufacturer: "Neuhaus Lighting Group", model: "ZBT-ExtendedColor", deviceJoinName: "Q-Smart Light", mnmn:"SmartThings", vid: "generic-rgbw-color-bulb-1800K-6500K"

		// Ajax Online
		fingerprint manufacturer: "Ajaxonline", model: "AJ-RGBCCT 5 in 1", deviceJoinName: "Ajax Light", mnmn: "SmartThings", vid: "generic-rgbw-color-bulb-2000K-6500K"
		fingerprint manufacturer: "Ajax online Ltd", model: "AJ_ZB30_GU10", deviceJoinName: "Ajax Light", mnmn: "SmartThings", vid: "generic-rgbw-color-bulb-2000K-6500K" // Raw Description: 0B 0104 010D 01 08 0000 0003 0004 0005 0006 0008 0300 1000 00
		// Shenzhen C-Lux
		fingerprint manufacturer: "Shenzhen C-Lux", model: "CL000ZB", deviceJoinName: "C-Lux Light", mnmn: "SmartThings", vid: "generic-rgbw-color-bulb-2000K-6500K"
	}

	// UI tile definitions
	tiles(scale: 2) {
		multiAttributeTile(name:"switch", type: "lighting", width: 6, height: 4, canChangeIcon: true){
			tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {
				attributeState "on", label:'${name}', action:"switch.off", icon:"st.lights.philips.hue-single", backgroundColor:"#00A0DC", nextState:"turningOff"
				attributeState "off", label:'${name}', action:"switch.on", icon:"st.lights.philips.hue-single", backgroundColor:"#ffffff", nextState:"turningOn"
				attributeState "turningOn", label:'${name}', action:"switch.off", icon:"st.lights.philips.hue-single", backgroundColor:"#00A0DC", nextState:"turningOff"
				attributeState "turningOff", label:'${name}', action:"switch.on", icon:"st.lights.philips.hue-single", backgroundColor:"#ffffff", nextState:"turningOn"
			}
			tileAttribute ("device.level", key: "SLIDER_CONTROL") {
				attributeState "level", action:"switch level.setLevel"
			}
			tileAttribute ("device.color", key: "COLOR_CONTROL") {
				attributeState "color", action:"color control.setColor"
			}
		}
		controlTile("colorTempSliderControl", "device.colorTemperature", "slider", width: 4, height: 2, inactiveLabel: false, range:"(2700..6500)") {
			state "colorTemperature", action:"color temperature.setColorTemperature"
		}
		valueTile("colorName", "device.colorName", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
			state "colorName", label: '${currentValue}'
		}
		standardTile("refresh", "device.refresh", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
			state "default", label:"", action:"refresh.refresh", icon:"st.secondary.refresh"
		}

		main(["switch"])
		details(["switch", "colorTempSliderControl", "colorName", "refresh"])
	}
}

//Globals
private getATTRIBUTE_HUE() { 0x0000 }
private getATTRIBUTE_SATURATION() { 0x0001 }
private getHUE_COMMAND() { 0x00 }
private getSATURATION_COMMAND() { 0x03 }
private getMOVE_TO_HUE_AND_SATURATION_COMMAND() { 0x06 }
private getCOLOR_CONTROL_CLUSTER() { 0x0300 }

// Parse incoming device messages to generate events
def parse(String description) {
	log.debug "description is $description"

	def event = zigbee.getEvent(description)
	if (event) {
		log.debug event
		if (event.name == "level" && event.value == 0) {}
		else {
			if (event.name == "colorTemperature") {
				setGenericName(event.value)
			}
			sendEvent(event)
		}
	}
	else {
		def zigbeeMap = zigbee.parseDescriptionAsMap(description)
		def cluster = zigbee.parse(description)

		if (zigbeeMap?.clusterInt == COLOR_CONTROL_CLUSTER) {
			if(zigbeeMap.attrInt == ATTRIBUTE_HUE){  //Hue Attribute
				state.hueValue = Math.round(zigbee.convertHexToInt(zigbeeMap.value) / 0xfe * 100)
				runIn(5, updateColor, [overwrite: true])
			}
			else if(zigbeeMap.attrInt == ATTRIBUTE_SATURATION){ //Saturation Attribute
				state.saturationValue = Math.round(zigbee.convertHexToInt(zigbeeMap.value) / 0xfe * 100)
				runIn(5, updateColor, [overwrite: true])
			}
		}
		else if (cluster && cluster.clusterId == 0x0006 && cluster.command == 0x07) {
			if (cluster.data[0] == 0x00){
				log.debug "ON/OFF REPORTING CONFIG RESPONSE: " + cluster
				sendEvent(name: "checkInterval", value: 60 * 12, displayed: false, data: [protocol: "zigbee", hubHardwareId: device.hub.hardwareID])
			}
			else {
				log.warn "ON/OFF REPORTING CONFIG FAILED- error code:${cluster.data[0]}"
			}
		}
		else {
			log.info "DID NOT PARSE MESSAGE for description : $description"
			log.debug zigbeeMap
		}
	}
}

def updateColor() {
	sendEvent(name: "hue", value: state.hueValue, descriptionText: "Color has changed")
	sendEvent(name: "saturation", value: state.saturationValue, descriptionText: "Color has changed", displayed: false)
}

def on() {
	zigbee.on()
}

def off() {
	zigbee.off()
}
/**
 * PING is used by Device-Watch in attempt to reach the Device
 * */
def ping() {
	return zigbee.onOffRefresh()
}

def refresh() {
	zigbee.onOffRefresh() +
	zigbee.levelRefresh() +
	zigbee.colorTemperatureRefresh() +
	zigbee.hueSaturationRefresh()
}

def configure() {
	log.debug "Configuring Reporting and Bindings."
	// Device-Watch allows 2 check-in misses from device + ping (plus 1 min lag time)
	// enrolls with default periodic reporting until newer 5 min interval is confirmed
	sendEvent(name: "checkInterval", value: 2 * 10 * 60 + 1 * 60, displayed: false, data: [protocol: "zigbee", hubHardwareId: device.hub.hardwareID])


	def cmds = []
	if(device.currentState("colorTemperature")?.value == null) {
		cmds +=	zigbee.setColorTemperature(5000)
	}

	cmds += refresh() +
	// OnOff, level minReportTime 0 seconds, maxReportTime 5 min. Reporting interval if no activity
	zigbee.onOffConfig() +
	zigbee.levelConfig()
	cmds
}

def setColorTemperature(value) {
	value = value as Integer

	zigbee.setColorTemperature(value) +
	zigbee.colorTemperatureRefresh()
}

//Naming based on the wiki article here: http://en.wikipedia.org/wiki/Color_temperature
def setGenericName(value){
	if (value != null) {
		def genericName = "White"
		if (value < 3300) {
			genericName = "Soft White"
		} else if (value < 4150) {
			genericName = "Moonlight"
		} else if (value <= 5000) {
			genericName = "Cool White"
		} else if (value >= 5000) {
			genericName = "Daylight"
		}
		sendEvent(name: "colorName", value: genericName)
	}
}

def setLevel(value, rate = null) {
	zigbee.setLevel(value)
}

private getScaledHue(value) {
	zigbee.convertToHexString(Math.round(value * 0xfe / 100.0), 2)
}

private getScaledSaturation(value) {
	zigbee.convertToHexString(Math.round(value * 0xfe / 100.0), 2)
}

def setColor(value){
	log.trace "setColor($value)"
	zigbee.on() +
	zigbee.command(COLOR_CONTROL_CLUSTER, MOVE_TO_HUE_AND_SATURATION_COMMAND,
		getScaledHue(value.hue), getScaledSaturation(value.saturation), "0000") +
	zigbee.hueSaturationRefresh()
}

def setHue(value) {
	zigbee.command(COLOR_CONTROL_CLUSTER, HUE_COMMAND, getScaledHue(value), "00", "0000") +
	zigbee.readAttribute(COLOR_CONTROL_CLUSTER, ATTRIBUTE_HUE)
}

def setSaturation(value) {
	zigbee.command(COLOR_CONTROL_CLUSTER, SATURATION_COMMAND, getScaledSaturation(value), "0000") +
	zigbee.readAttribute(COLOR_CONTROL_CLUSTER, ATTRIBUTE_SATURATION)
}

def installed() {
	if (((device.getDataValue("manufacturer") == "MRVL") && (device.getDataValue("model") == "MZ100")) || (device.getDataValue("manufacturer") == "OSRAM SYLVANIA") || (device.getDataValue("manufacturer") == "OSRAM")) {
		if ((device.currentState("level")?.value == null) || (device.currentState("level")?.value == 0)) {
			sendEvent(name: "level", value: 100)
		}
	} else if (isTintBulb()) {
		sendHubCommand(zigbee.command(COLOR_CONTROL_CLUSTER, MOVE_TO_HUE_AND_SATURATION_COMMAND, getScaledHue(0), getScaledSaturation(0), "0000"))
	}
}

private boolean isTintBulb() {
	device.getDataValue("model") == "ZBT-ExtendedColor"
}
