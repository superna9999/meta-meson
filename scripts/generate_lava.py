#!/usr/bin/env python3

from jinja2 import Environment, FileSystemLoader
import argparse

parser = argparse.ArgumentParser()
parser.add_argument("--template")
parser.add_argument("--info")
parser.add_argument("--base-artifacts-url")
parser.add_argument("--device-type")
parser.add_argument("--kernel-image-name")
parser.add_argument("--dtb-name")
parser.add_argument("--ramdisk-name")
parser.add_argument("--ramdisk-compression")
parser.add_argument("--boot-method")
parser.add_argument("--tags")
args = parser.parse_args()

env = Environment(loader = FileSystemLoader('.'), trim_blocks=True, lstrip_blocks=True)
template = env.get_template(args.template)

values = {}
values['info'] = args.info
values['base_artifacts_url'] = args.base_artifacts_url
values['device_type'] = args.device_type
values['kernel_image_name'] = args.kernel_image_name
values['dtb_name'] = args.dtb_name
values['ramdisk_name'] = args.ramdisk_name
values['ramdisk_compression'] = args.ramdisk_compression
values['boot_method'] = args.boot_method
if args.tags:
    values['tags'] = args.tags.split(",")

print(template.render(values))
