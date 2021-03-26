targetConfigurations = [
        "x64Mac"      : [
                "openj9"
        ],
        "x64Linux"    : [
                "openj9"
        ],
        "x64Windows"  : [
                "openj9"
        ],
        "ppc64Aix"    : [
                "openj9"
        ],
        "ppc64leLinux": [
                "openj9"
        ],
        "s390xLinux"  : [
                "openj9"
        ],
        "aarch64Linux": [
                "openj9"
        ]
]

// Weeknights at H9:00pm
triggerSchedule_nightly="59 23 * * 2,4"
// H9:00am Sat
triggerSchedule_weekly="30 10 * * 6"

// scmReferences to use for weekly release build
weekly_release_scmReferences=[
        "openj9"         : ""
]

return this
