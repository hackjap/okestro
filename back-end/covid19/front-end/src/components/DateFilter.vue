<template>
	<v-card flat class="py-12">
		<v-card-text>
			<v-row align="center" justify="center">
				<v-col cols="12">
					<p class="text-center">
						코로나바이러스-19
					</p>
				</v-col>
				<v-btn-toggle v-model="toggle_exclusive" rounded>
					<v-btn @click="$emit('fetch', 7)">
						<!-- <v-icon>mdi-format-align-left</v-icon> -->
						최근7일전
					</v-btn>
					<v-btn @click="$emit('fetch', 30)">
						최근30일전
					</v-btn>
					<v-btn @click="$emit('fetch', 90)">
						최근 3개월 전
					</v-btn>
				</v-btn-toggle>
			</v-row>
		</v-card-text>
	</v-card>
</template>
<script>
export default {
	data() {
		return {
			toggle_exclusive: undefined,
		};
	},
};
</script>
